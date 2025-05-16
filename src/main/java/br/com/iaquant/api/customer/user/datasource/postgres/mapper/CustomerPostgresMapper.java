package br.com.iaquant.api.customer.user.datasource.postgres.mapper;

import br.com.iaquant.api.customer.user.datasource.postgres.entity.CustomerTable;
import br.com.iaquant.api.customer.user.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface CustomerPostgresMapper {
    CustomerTable map(Customer customer);

    Customer map(CustomerTable customerTable);
}
