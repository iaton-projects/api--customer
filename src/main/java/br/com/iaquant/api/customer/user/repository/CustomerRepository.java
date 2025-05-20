package br.com.iaquant.api.customer.user.repository;

import br.com.iaquant.api.customer.user.entity.Customer;

public interface CustomerRepository {
    Customer findCustomerByEmail(String email);

    Customer findCustomerByUsername(String username);

    Customer findCustomerById(Long id);

    Customer save(Customer customer);


}

