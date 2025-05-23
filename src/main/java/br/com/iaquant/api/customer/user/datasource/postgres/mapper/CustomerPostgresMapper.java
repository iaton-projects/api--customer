package br.com.iaquant.api.customer.user.datasource.postgres.mapper;

import br.com.iaquant.api.customer.user.datasource.postgres.entity.CustomerTable;
import br.com.iaquant.api.customer.user.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface CustomerPostgresMapper {
    CustomerTable map(Customer customer);

    Customer map(CustomerTable customerTable);

    default Customer map(Optional<CustomerTable> customerTableOptional) {
        return map(customerTableOptional.orElse(null));
    }

    default Page<Customer> map(Page<CustomerTable> customerTablePage) {
        List<Customer> content = map(customerTablePage.getContent());
        return new PageImpl<>(content, customerTablePage.getPageable(), customerTablePage.getTotalElements());
    }

    List<Customer> map(List<CustomerTable> list);
}
