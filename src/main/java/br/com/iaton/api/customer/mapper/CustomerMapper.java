package br.com.iaton.api.customer.mapper;

import br.com.iaton.api.customer.entity.Customer;
import br.com.iaton.api.customer.entity.Filter;
import br.com.iaton.api.customer.openapi.model.domain.*;
import br.com.iaton.api.customer.entity.Status;
import br.com.iaton.api.customer.utils.Constants;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    CustomerResponse map(Customer response);

    Customer map(CustomerRequest request);

    StatusResponse map(Status response);

    ListCustomerResponse map(Page<Customer> response);

    Filter map(FilterRequest filterRequest);

    default PageRequest map(Integer page) {
        return PageRequest.of(page, Constants.NUMBER_PAGES, Sort.by(Constants.SORT_ATTRIBUTE));
    }


}
