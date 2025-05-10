package br.com.iaquant.api.customer.user.mapper;

import br.com.iaquant.api.customer.user.entity.Address;
import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.entity.Status;
import br.com.iaquant.api.customer.user.entity.User;
import br.com.iaquant.api.customer.user.openapi.model.domain.AddressResponse;
import br.com.iaquant.api.customer.user.openapi.model.domain.CustomerRequest;
import br.com.iaquant.api.customer.user.openapi.model.domain.CustomerResponse;
import br.com.iaquant.api.customer.user.openapi.model.domain.StatusResponse;
import br.com.iaquant.api.customer.user.openapi.model.domain.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T23:59:38-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.7 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponse map(Customer response) {
        if ( response == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        if ( response.getId() != null ) {
            customerResponse.setId( response.getId().intValue() );
        }
        customerResponse.setName( response.getName() );
        customerResponse.setTaxId( response.getTaxId() );
        customerResponse.setEmail( response.getEmail() );
        customerResponse.setPhone( response.getPhone() );
        customerResponse.setGender( response.getGender() );
        customerResponse.setBirthDate( response.getBirthDate() );
        customerResponse.setAddress( addressToAddressResponse( response.getAddress() ) );
        customerResponse.setUser( userToUserResponse( response.getUser() ) );

        return customerResponse;
    }

    @Override
    public Customer map(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Customer customer = new Customer();

        if ( request.getId() != null ) {
            customer.setId( request.getId().longValue() );
        }
        customer.setName( request.getName() );
        customer.setEmail( request.getEmail() );
        customer.setPhone( request.getPhone() );
        customer.setTaxId( request.getTaxId() );
        customer.setBirthDate( request.getBirthDate() );
        customer.setGender( request.getGender() );
        customer.setUser( userResponseToUser( request.getUser() ) );
        customer.setAddress( addressResponseToAddress( request.getAddress() ) );

        return customer;
    }

    @Override
    public StatusResponse map(Status response) {
        if ( response == null ) {
            return null;
        }

        StatusResponse statusResponse = new StatusResponse();

        statusResponse.setCode( response.code() );
        statusResponse.setDescription( response.description() );

        return statusResponse;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        if ( address.getId() != null ) {
            addressResponse.setId( address.getId().intValue() );
        }
        addressResponse.setAddress( address.getAddress() );
        addressResponse.setNeighborhood( address.getNeighborhood() );
        addressResponse.setCity( address.getCity() );
        addressResponse.setState( address.getState() );
        addressResponse.setComplement( address.getComplement() );

        return addressResponse;
    }

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        if ( user.getId() != null ) {
            userResponse.setId( user.getId().intValue() );
        }
        userResponse.setUsername( user.getUsername() );
        userResponse.setPassword( user.getPassword() );

        return userResponse;
    }

    protected User userResponseToUser(UserResponse userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        User user = new User();

        if ( userResponse.getId() != null ) {
            user.setId( userResponse.getId().longValue() );
        }
        user.setUsername( userResponse.getUsername() );
        user.setPassword( userResponse.getPassword() );

        return user;
    }

    protected Address addressResponseToAddress(AddressResponse addressResponse) {
        if ( addressResponse == null ) {
            return null;
        }

        Address address = new Address();

        if ( addressResponse.getId() != null ) {
            address.setId( addressResponse.getId().longValue() );
        }
        address.setAddress( addressResponse.getAddress() );
        address.setNeighborhood( addressResponse.getNeighborhood() );
        address.setCity( addressResponse.getCity() );
        address.setState( addressResponse.getState() );
        address.setComplement( addressResponse.getComplement() );

        return address;
    }
}
