package br.com.iaquant.api.customer.user.datasource;

import br.com.iaquant.api.customer.user.aspect.ObjectReturnType;
import br.com.iaquant.api.customer.user.aspect.ReturnNullObject;
import br.com.iaquant.api.customer.user.datasource.postgres.mapper.CustomerPostgresMapper;
import br.com.iaquant.api.customer.user.datasource.postgres.repository.CustomerPostgresRepository;
import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CustomerDataSource implements CustomerRepository {

    private final CustomerPostgresRepository customerPostgresRepository;

    private final CustomerPostgresMapper customerPostgresMapper;

    public CustomerDataSource(CustomerPostgresRepository customerPostgresRepository, CustomerPostgresMapper customerPostgresMapper) {
        this.customerPostgresRepository = customerPostgresRepository;
        this.customerPostgresMapper = customerPostgresMapper;
    }

    @Transactional
    public void save(Customer customer) {
        customerPostgresRepository.save(customerPostgresMapper.map(customer));
    }


    @ReturnNullObject(ObjectReturnType.OBJECT)
    public Customer findByEmail(String email) {
        return customerPostgresMapper.map(customerPostgresRepository.findByEmail(email));
    }

    @ReturnNullObject(ObjectReturnType.OBJECT)
    public Customer findByUsername(String username) {
        return customerPostgresMapper.map(customerPostgresRepository.findByUserUsername(username));
    }
}
