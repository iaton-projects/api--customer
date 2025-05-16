package br.com.iaquant.api.customer.user.usecase;

import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.entity.Status;
import br.com.iaquant.api.customer.user.repository.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerUseCase {

    private final CustomerRepository customerRepository;

    public CustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Status save(Customer customer) {
        customerRepository.save(customer);
        return new Status(0,"SUCESSO");
    }

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

}