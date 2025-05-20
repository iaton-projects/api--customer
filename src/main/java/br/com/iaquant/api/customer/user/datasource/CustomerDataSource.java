package br.com.iaquant.api.customer.user.datasource;

import br.com.iaquant.api.customer.user.aspect.ObjectReturnType;
import br.com.iaquant.api.customer.user.aspect.ReturnNullObject;
import br.com.iaquant.api.customer.user.datasource.postgres.entity.CustomerTable;
import br.com.iaquant.api.customer.user.datasource.postgres.mapper.CustomerPostgresMapper;
import br.com.iaquant.api.customer.user.datasource.postgres.repository.CustomerPostgresRepository;
import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDataSource implements CustomerRepository {

    private final CustomerPostgresRepository customerPostgresRepository;

    private final CustomerPostgresMapper customerPostgresMapper;

    public CustomerDataSource(CustomerPostgresRepository customerPostgresRepository, CustomerPostgresMapper customerPostgresMapper) {
        this.customerPostgresRepository = customerPostgresRepository;
        this.customerPostgresMapper = customerPostgresMapper;
    }

    @Transactional
    public Customer save(Customer customer) {
        var customerTable = customerPostgresMapper.map(customer);
        customerPostgresRepository.save(customerTable);
        return customerPostgresMapper.map(customerTable);

    }


    @ReturnNullObject(ObjectReturnType.OBJECT)
    public Customer findCustomerByEmail(String email) {
        return customerPostgresMapper.map(customerPostgresRepository.findByEmail(email));
    }

    @ReturnNullObject(ObjectReturnType.OBJECT)
    public Customer findCustomerByUsername(String username) {
        return customerPostgresMapper.map(customerPostgresRepository.findByUserUsername(username));
    }

    @ReturnNullObject(ObjectReturnType.OBJECT)
    public Customer findCustomerById(Long id) {
        Optional<CustomerTable> customerTableOptional = customerPostgresRepository.findById(id);
        return customerPostgresMapper.map(customerTableOptional);
    }
}
