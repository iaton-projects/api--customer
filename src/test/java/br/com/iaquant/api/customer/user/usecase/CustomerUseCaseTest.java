package br.com.iaquant.api.customer.user.usecase;


import br.com.iaquant.api.customer.user.entity.Address;
import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.entity.Status;
import br.com.iaquant.api.customer.user.entity.User;
import br.com.iaquant.api.customer.user.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerUseCaseTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    NotificationUseCase notificationUseCase;

    @InjectMocks
    CustomerUseCase customerUseCase;

    @Test
    void shouldFindCustomerByIdSuccess() {
        when(customerRepository.findCustomerById(anyLong())).thenReturn(getCustomer());
        var customer = customerUseCase.findCustomerById(1L);
        assertNotNull(customer);
    }

    @Test
    void shouldFindCustomerByEmailSuccess() {
        when(customerRepository.findCustomerByEmail(anyString())).thenReturn(getCustomer());
        var customer = customerUseCase.findCustomerByEmail("email@email.com");
        assertNotNull(customer);
    }

    @Test
    void shouldFindCustomerByUsernameSuccess() {
        when(customerRepository.findCustomerByUsername(anyString())).thenReturn(getCustomer());
        var customer = customerUseCase.findCustomerByUsername("usuario");
        assertNotNull(customer);
    }

    @Test
    void shouldSaveCustomerSuccess() {
        when(customerRepository.save(any(Customer.class))).thenReturn(new Customer().setId(1L));
        when(notificationUseCase.sendNotification(any(Customer.class))).thenReturn(new Status(0, "SUCESSO"));
        var customer = getCustomer();
        var status = customerUseCase.save(customer);
        verify(customerRepository, times(1)).save(any(Customer.class));
        verify(notificationUseCase, times(1)).sendNotification(any(Customer.class));
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
