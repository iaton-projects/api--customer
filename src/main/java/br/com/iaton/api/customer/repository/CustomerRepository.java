package br.com.iaton.api.customer.repository;

import br.com.iaton.api.customer.entity.Customer;
import br.com.iaton.api.customer.entity.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerRepository {

    Page<Customer> filter(Pageable page);

    Page<Customer> filter(Filter filter, Pageable page);

    Customer findCustomerByEmail(String email);

    Customer findCustomerByUsername(String username);

    Customer findCustomerById(Long id);

    Customer save(Customer customer);

    void delete(Long id);



}

