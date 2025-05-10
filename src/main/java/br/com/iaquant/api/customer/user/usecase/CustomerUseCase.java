package br.com.iaquant.api.customer.user.usecase;


import br.com.iaquant.api.customer.user.aspect.ObjectReturnType;
import br.com.iaquant.api.customer.user.aspect.ReturnNullObject;
import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.entity.Status;
import br.com.iaquant.api.customer.user.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class CustomerUseCase {

    private final CustomerRepository customerRepository;


    public CustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Transactional
    public Status save(Customer customer) {
        customerRepository.save(customer);
        return new Status(0,"SUCESSO");
    }


    @ReturnNullObject(ObjectReturnType.OBJECT)
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }

    @ReturnNullObject(ObjectReturnType.OBJECT)
    public Customer findByUsername(String username) {
        return customerRepository.findByUserUsername(username).orElse(null);
    }


}