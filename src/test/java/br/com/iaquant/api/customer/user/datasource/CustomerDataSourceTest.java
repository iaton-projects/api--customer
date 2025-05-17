package br.com.iaquant.api.customer.user.datasource;


import br.com.iaquant.api.customer.user.datasource.postgres.entity.AddressTable;
import br.com.iaquant.api.customer.user.datasource.postgres.entity.CustomerTable;
import br.com.iaquant.api.customer.user.datasource.postgres.entity.UserTable;

import br.com.iaquant.api.customer.user.datasource.postgres.mapper.CustomerPostgresMapperImpl;
import br.com.iaquant.api.customer.user.datasource.postgres.repository.CustomerPostgresRepository;
import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.exception.ElementNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerDataSourceTest extends AbstractDataSourceTest {

    @Mock
    private CustomerPostgresRepository customerPostgresRepository;

    @Spy
    CustomerPostgresMapperImpl customerPostgresMapper;

    @InjectMocks
    private CustomerDataSource customerDataSource;

    @BeforeEach
    void setup() {
        customerDataSource = setupDataSourceTest(customerDataSource);
    }

    @Test
    void shouldFindCustomerByIdSuccess() {

        for (Method m : customerPostgresRepository.getClass().getMethods()) {
            if (m.getName().equals("findById")) {
                System.out.println(m + " retorna " + m.getReturnType());
            }
        }

        when(customerPostgresRepository.findById(anyLong())).thenReturn(Optional.of(getCustomer()));
        var customer = customerDataSource.findCustomerById(1L);
        assertNotNull(customer);
    }

    @Test
    void shouldThrow_ElementNotFoundException_CustomerByIdNull() {
        when(customerPostgresRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ElementNotFoundException.class, () -> customerDataSource.findCustomerById(1L));
    }

    @Test
    void shouldFindCustomerByEmailSuccess() {
        when(customerPostgresRepository.findByEmail(anyString())).thenReturn(getCustomer());
        var customer = customerDataSource.findCustomerByEmail("email@email.com");
        assertNotNull(customer);
    }

    @Test
    void shouldThrow_ElementNotFoundException_CustomerByEmailNull() {
        when(customerPostgresRepository.findByEmail(anyString())).thenReturn(null);
        assertThrows(ElementNotFoundException.class, () -> customerDataSource.findCustomerByEmail("email@email.com"));
    }

    @Test
    void shouldFindCustomerByUsernameSuccess() {
        when(customerPostgresRepository.findByUserUsername(anyString())).thenReturn(getCustomer());
        var customer = customerDataSource.findCustomerByUsername("usuario");
        assertNotNull(customer);
    }

    @Test
    void shouldThrow_ElementNotFoundException_CustomerByUsernameNull() {
        when(customerPostgresRepository.findByUserUsername(anyString())).thenReturn(null);
        assertThrows(ElementNotFoundException.class, () -> customerDataSource.findCustomerByUsername("usuario"));
    }

    @Test
    void shouldSaveCustomerSuccess() {
        customerDataSource.save(new Customer());
        verify(customerPostgresRepository, times(1)).save(any(CustomerTable.class));
    }

    private static CustomerTable getCustomer() {
        return new CustomerTable()
                .setId(1L)
                .setName("John Doe")
                .setEmail("johndoe@example.com")
                .setPhone("+55 21 98765-4321")
                .setTaxId("123.456.789-00")
                .setBirthDate(LocalDate.of(1990, 5, 15))
                .setGender("Male")
                .setUser(new UserTable()
                        .setId(1L)
                        .setUsername("user")
                        .setPassword("password"))
                .setAddress(new AddressTable()
                        .setId(1L)
                        .setZipCode("20000-000")
                        .setAddress("Fake street")
                        .setNeighborhood("Centro")
                        .setCity("Rio de Janeiro")
                        .setState("RJ")
                        .setComplement("CASA"));
    }

}
