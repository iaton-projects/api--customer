package br.com.iaquant.api.customer.user.repository;

import br.com.iaquant.api.customer.user.entity.Customer;

public interface CustomerRepository {
    Customer findByEmail(String email);

    Customer findByUsername(String username);

    void save(Customer customer);
}

