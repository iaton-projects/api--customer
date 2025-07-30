package br.com.iaton.api.customer.mock;

import br.com.iaton.api.customer.entity.Address;
import br.com.iaton.api.customer.entity.Customer;
import br.com.iaton.api.customer.entity.Filter;
import br.com.iaton.api.customer.entity.User;

import java.time.LocalDate;

public class CustomerMock {

    public static Customer getCustomer_SendNotification() {
        return new Customer().setId(1L).setFirstName("name").setLastName("last name");
    }


    public static Customer getCustomer() {
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
}
