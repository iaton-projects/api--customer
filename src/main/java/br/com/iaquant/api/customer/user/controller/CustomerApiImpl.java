package br.com.iaquant.api.customer.user.controller;

import br.com.iaquant.api.customer.user.config.CustomerMetrics;
import br.com.iaquant.api.customer.user.openapi.controller.CustomerApi;
import br.com.iaquant.api.customer.user.openapi.model.domain.*;
import br.com.iaquant.api.customer.user.mapper.CustomerMapper;
import br.com.iaquant.api.customer.user.usecase.CustomerUseCase;
import br.com.iaquant.api.customer.user.utils.Constants;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return ResponseEntity.ok(customerMapper.map(customerUseCase.filter(PageRequest.of(0, Constants.NUMBER_PAGES, Sort.by(Constants.SORT_ATTRIBUTE)))));
    }

    @Override
    public ResponseEntity<ListCustomerResponse> filterCustomer(FilterRequest filterRequest) {
        return ResponseEntity.ok(customerMapper.map(customerUseCase.filter(PageRequest.of(filterRequest.getPage(), Constants.NUMBER_PAGES, Sort.by(Constants.SORT_ATTRIBUTE)))));
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
