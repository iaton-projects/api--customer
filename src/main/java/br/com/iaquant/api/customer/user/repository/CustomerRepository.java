package br.com.iaquant.api.customer.user.repository;

import br.com.iaquant.api.customer.user.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerRepository {

    Page<Customer> filter(Pageable page);

    Customer findCustomerByEmail(String email);

    Customer findCustomerByUsername(String username);

    Customer findCustomerById(Long id);

    Customer save(Customer customer);

    void delete(Long id);


}

