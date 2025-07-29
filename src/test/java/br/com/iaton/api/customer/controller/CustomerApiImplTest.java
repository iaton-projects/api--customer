package br.com.iaton.api.customer.controller;

import br.com.iaton.api.customer.config.CustomerMetrics;
import br.com.iaton.api.customer.entity.*;
import br.com.iaton.api.customer.entity.*;
import br.com.iaton.api.customer.exception.ElementNotFoundException;
import br.com.iaton.api.customer.exception.ListNotFoundException;
import br.com.iaton.api.customer.handler.ControllerErrorHandler;
import br.com.iaton.api.customer.mapper.CustomerMapper;
import br.com.iaton.api.customer.openapi.model.domain.CustomerRequest;
import br.com.iaton.api.customer.openapi.model.domain.FilterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.iaton.api.customer.usecase.CustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerApiImplTest {



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
    void shouldReturnHttp200_ListCustomer() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customer/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
    void shouldReturnHttp204_ListCustomer() throws Exception {
        when(customerUseCase.listAll(any(PageRequest.class))).thenThrow(new ListNotFoundException("Erro"));
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customer/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isNoContent());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
    void shouldReturnHttp200_FilterCustomer() throws Exception {
        when(customerUseCase.filter(any(Filter.class), any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(getCustomer())));
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/list")
                        .content(new ObjectMapper().writeValueAsString(getFilter()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
    void shouldReturnHttp204_FilterCustomer() throws Exception {
        when(customerUseCase.filter(any(Filter.class), any(PageRequest.class))).thenThrow(new ListNotFoundException("Erro"));
        when(customerMapper.map(any(FilterRequest.class))).thenReturn(new Filter());
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/list")
                        .content(new ObjectMapper().writeValueAsString(getFilter()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isNoContent());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
    void shouldReturnHttp200_GetCustomerById() throws Exception {
        when(customerUseCase.findCustomerById(anyLong())).thenReturn(getCustomer());
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customer/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
    void shouldReturnHttp404_GetCustomerById() throws Exception {
        when(customerUseCase.findCustomerById(anyLong())).thenThrow(new ElementNotFoundException("ERRO"));
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customer/id/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isNotFound());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }

    @Test
     void shouldReturnHttp200_GetCustomerByEmail() throws Exception {
        when(customerUseCase.findCustomerByEmail(anyString())).thenReturn(getCustomer());
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
        when(customerUseCase.findCustomerByEmail(anyString())).thenThrow(new ElementNotFoundException("ERRO"));
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
        when(customerUseCase.findCustomerByUsername(anyString())).thenReturn(getCustomer());
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
        when(customerUseCase.findCustomerByUsername(anyString())).thenThrow(new ElementNotFoundException("ERRO"));
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

    @Test
    void shouldReturnHttp200_DeleteCustomer() throws Exception {
        when(customerUseCase.delete(anyLong())).thenReturn(new Status(0, ""));
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/api/customer/{id}", 3L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk());

        verify(customerMetrics, times(0)).incrementCustomerSuccessCount();
    }


    private CustomerRequest getCustomerRequest() {
        var informacaoRequest = new CustomerRequest();
        informacaoRequest.setFirstName("NOME");
        informacaoRequest.setLastName("SOBRENOME");
        return informacaoRequest;

    }

    private static Customer getCustomer() {
        return new Customer()
                .setId(1L)
                .setFirstName("John")
                .setLastName("Doe")
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


    private static FilterRequest getFilter() {
        var filtroBusca = new FilterRequest();
        filtroBusca.setPage(1);
        filtroBusca.setFilter("nome");
        return filtroBusca;
    }

}