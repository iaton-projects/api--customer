package br.com.iaquant.api.customer.user.usecase;


import br.com.iaquant.api.customer.user.entity.Address;
import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.entity.User;
import br.com.iaquant.api.customer.user.exception.ElementNotFoundException;
import br.com.iaquant.api.customer.user.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerUseCaseTest extends AbstractUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerUseCase customerUseCase;

    @BeforeEach
    void setup() {
        customerUseCase = setupUseCaseTest(customerUseCase);
    }


    @Test
    void shouldFindCustomerByEmailSuccess() {
        when(customerRepository.findByEmail(anyString())).thenReturn(Optional.of(getCustomer()));
        var customer = customerUseCase.findByEmail("email@email.com");
        assertNotNull(customer);
    }

    @Test
    void shouldThrow_ElementNotFoundException_CustomerByEmailNull() {
        when(customerRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        assertThrows(ElementNotFoundException.class, () -> customerUseCase.findByEmail("email@email.com"));
    }

    @Test
    void shouldFindCustomerByUsernameSuccess() {
        when(customerRepository.findByUserUsername(anyString())).thenReturn(Optional.of(getCustomer()));
        var customer = customerUseCase.findByUsername("usuario");
        assertNotNull(customer);
    }

    @Test
    void shouldThrow_ElementNotFoundException_CustomerByUsernameNull() {
        when(customerRepository.findByUserUsername(anyString())).thenReturn(Optional.empty());
        assertThrows(ElementNotFoundException.class, () -> customerUseCase.findByUsername("usuario"));
    }

    @Test
    void shouldSaveCustomerSuccess() {
        var customer = getCustomer();
        var status = customerUseCase.save(customer);
        verify(customerRepository, times(1)).save(any(Customer.class));
        assertNotNull(status);
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
