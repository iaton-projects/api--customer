package br.com.iaton.api.customer.controller;

import br.com.iaton.api.customer.config.CustomerMetrics;
import br.com.iaton.api.customer.openapi.controller.CustomerApi;
import br.com.iaton.api.customer.openapi.model.domain.*;
import br.com.iaton.api.customer.mapper.CustomerMapper;
import br.com.iaton.api.customer.usecase.CustomerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerApiImpl implements CustomerApi {

    private final CustomerUseCase customerUseCase;

    private final CustomerMapper customerMapper;

    private final CustomerMetrics customerMetrics;

    public CustomerApiImpl(CustomerUseCase customerUseCase, CustomerMapper customerMapper, CustomerMetrics customerMetrics) {
        this.customerUseCase = customerUseCase;
        this.customerMapper = customerMapper;
        this.customerMetrics = customerMetrics;
    }

    @Override
    public ResponseEntity<ListCustomerResponse> listAllCustomer() {
        return ResponseEntity.ok(customerMapper.map(customerUseCase.listAll(customerMapper.map(0))));
    }

    @Override
    public ResponseEntity<ListCustomerResponse> filterCustomer(FilterRequest filterRequest) {
        return ResponseEntity.ok(customerMapper.map(customerUseCase.filter(customerMapper.map(filterRequest), customerMapper.map(filterRequest.getPage()))));
    }

    @Override
    public ResponseEntity<CustomerResponse> getCustomerById(Long id) {
        return ResponseEntity.ok(customerMapper.map(customerUseCase.findCustomerById(id)));
    }

    @Override
    public ResponseEntity<CustomerResponse> getCustomerByEmail(String email) {
        return ResponseEntity.ok(customerMapper.map(customerUseCase.findCustomerByEmail(email)));
    }

    @Override
    public ResponseEntity<CustomerResponse> getCustomerByUsername(String username) {
        return ResponseEntity.ok(customerMapper.map(customerUseCase.findCustomerByUsername(username)));
    }

    @Override
    public ResponseEntity<StatusResponse> saveCustomer(CustomerRequest customerRequest) {
        var response = ResponseEntity.status(201).body(customerMapper.map(customerUseCase.save(customerMapper.map(customerRequest))));
        customerMetrics.incrementCustomerSuccessCount();
        return response;
    }

    @Override
    public ResponseEntity<StatusResponse> deleteCustomer(Long id) {
        return ResponseEntity.ok(customerMapper.map(customerUseCase.delete(id)));
    }
}
