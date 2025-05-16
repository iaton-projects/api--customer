package br.com.iaquant.api.customer.user.controller;

import br.com.iaquant.api.customer.user.config.CustomerMetrics;
import br.com.iaquant.api.customer.user.entity.Address;
import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.entity.User;
import br.com.iaquant.api.customer.user.exception.ElementNotFoundException;
import br.com.iaquant.api.customer.user.handler.ControllerErrorHandler;
import br.com.iaquant.api.customer.user.mapper.CustomerMapper;
import br.com.iaquant.api.customer.user.openapi.model.domain.CustomerRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.iaquant.api.customer.user.entity.Status;
import br.com.iaquant.api.customer.user.usecase.CustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerTableApiImplTest {



    private MockMvc mockMvc;

    @Mock
    private CustomerUseCase customerUseCase;

    @Spy
    private CustomerMapper customerMapper;

    @Mock
    private CustomerMetrics customerMetrics;

    @InjectMocks
    private CustomerApiImpl controller;

    @BeforeEach
     void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new ControllerErrorHandler())
                .build();
    }


    @Test
     void shouldReturnHttp200_GetCustomerByEmail() throws Exception {
        when(customerUseCase.findByEmail(anyString())).thenReturn(getCustomer());
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customer/email/{email}", "email@email.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
     void shouldReturnHttp404_GetCustomerByEmail() throws Exception {
        when(customerUseCase.findByEmail(anyString())).thenThrow(new ElementNotFoundException("ERRO"));
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customer/email/{email}", "email@email.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isNotFound());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
    void shouldReturnHttp200_GetCustomerByUsername() throws Exception {
        when(customerUseCase.findByUsername(anyString())).thenReturn(getCustomer());
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customer/username/{username}", "username")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
    void shouldReturnHttp404_GetCustomerByUsername() throws Exception {
        when(customerUseCase.findByUsername(anyString())).thenThrow(new ElementNotFoundException("ERRO"));
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customer/username/{username}", "username")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isNotFound());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
     void shouldReturnHttp201_SaveCustomer() throws Exception {
        when(customerUseCase.save(any(Customer.class))).thenReturn(new Status(0, ""));
        when(customerMapper.map(any(CustomerRequest.class))).thenReturn(getCustomer());
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/save")
                        .content(new ObjectMapper().writeValueAsString(getCustomerRequest()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isCreated());

        verify(customerMetrics, times(1)).incrementCustomerSuccessCount();
    }

    private CustomerRequest getCustomerRequest() {
        var informacaoRequest = new CustomerRequest();
        informacaoRequest.setName("NOME");
        return informacaoRequest;

    }

    private static Customer getCustomer() {
        return new Customer()
                .setId(1L)
                .setName("John Doe")
                .setEmail("johndoe@example.com")
                .setPhone("+55 21 98765-4321")
                .setTaxId("123.456.789-00")
                .setBirthDate(LocalDate.of(1990, 5, 15))
                .setGender("Male")
                .setUser(new User()
                        .setId(1L)
                        .setUsername("user")
                        .setPassword("password"))
                .setAddress(new Address()
                        .setId(1L)
                        .setZipCode("20000-000")
                        .setAddress("Fake street")
                        .setNeighborhood("Centro")
                        .setCity("Rio de Janeiro")
                        .setState("RJ")
                        .setComplement("CASA"));
    }

}