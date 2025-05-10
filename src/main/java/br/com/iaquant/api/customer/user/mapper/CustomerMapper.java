package br.com.iaquant.api.customer.user.mapper;

import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.openapi.model.domain.CustomerRequest;
import br.com.iaquant.api.customer.user.openapi.model.domain.CustomerResponse;
import br.com.iaquant.api.customer.user.openapi.model.domain.StatusResponse;
import br.com.iaquant.api.customer.user.entity.Status;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    CustomerResponse map(Customer response);

    Customer map(CustomerRequest request);

    StatusResponse map(Status response);


}
