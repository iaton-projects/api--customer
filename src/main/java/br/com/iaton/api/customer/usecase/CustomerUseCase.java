package br.com.iaton.api.customer.usecase;

import br.com.iaton.api.customer.entity.Customer;
import br.com.iaton.api.customer.entity.Filter;
import br.com.iaton.api.customer.entity.Status;
import br.com.iaton.api.customer.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerUseCase {

    private final CustomerRepository customerRepository;

    private final NotificationUseCase notificationUseCase;

    public CustomerUseCase(CustomerRepository customerRepository, NotificationUseCase notificationUseCase) {
        this.customerRepository = customerRepository;
        this.notificationUseCase = notificationUseCase;
    }

    public Status save(Customer customer) {
        var customerSaved = customerRepository.save(customer);
        notificationUseCase.sendNotification(customerSaved);
        return new Status(0,"SUCESSO");
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }


    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    public Customer findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    public Status delete(Long id) {
        customerRepository.delete(id);
        return new Status(0,"SUCESSO");
    }

    public Page<Customer> listAll(Pageable pageRequest) {
        return customerRepository.filter(pageRequest);
    }

    public Page<Customer> filter(Filter filter, Pageable pageRequest) {
        return customerRepository.filter(filter, pageRequest);
    }
}