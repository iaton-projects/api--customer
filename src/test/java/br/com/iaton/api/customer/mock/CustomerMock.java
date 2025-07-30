package br.com.iaton.api.customer.mock;

import br.com.iaton.api.customer.entity.Customer;

public class CustomerMock {

    public static Customer getCustomer_SendNotification() {
        return new Customer().setId(1L).setFirstName("name").setLastName("last name");
    }
}
