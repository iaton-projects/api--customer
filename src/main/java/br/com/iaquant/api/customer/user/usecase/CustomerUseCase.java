package br.com.iaquant.api.customer.user.usecase;

import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.entity.Status;
import br.com.iaquant.api.customer.user.repository.CustomerRepository;
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

}