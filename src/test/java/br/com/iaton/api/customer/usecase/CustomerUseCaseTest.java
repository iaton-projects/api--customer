package br.com.iaton.api.customer.usecase;


import br.com.iaton.api.customer.entity.*;
import br.com.iaton.api.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
import java.util.Arrays;

import static br.com.iaton.api.customer.mock.CustomerMock.getCustomer;
import static br.com.iaton.api.customer.mock.FilterMock.getFilter;
import static br.com.iaton.api.customer.mock.StatusMock.getStatusSuccess;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerUseCaseTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    NotificationUseCase notificationUseCase;

    @InjectMocks
    CustomerUseCase customerUseCase;

    @Test
    void shouldListCustomerPageSuccess() {

        when(customerRepository.filter(any(Pageable.class))).thenReturn(new PageImpl<>(Arrays.asList(getCustomer())));
        var pageList = customerUseCase.listAll(PageRequest.of(1, 5, Sort.by("firstName")));
        assertNotNull(pageList);
        assertEquals(1, pageList.getTotalElements());
        assertEquals(1, pageList.getTotalPages());
    }

    @Test
    void shouldListCustomerPageFilterSuccess() {
        when(customerRepository.filter(any(Filter.class), any(Pageable.class))).thenReturn(new PageImpl<>(Arrays.asList(getCustomer())));
        var pageList = customerUseCase.filter(getFilter(), PageRequest.of(1, 5, Sort.by("firstName")));
        assertNotNull(pageList);
        assertEquals(1, pageList.getTotalElements());
        assertEquals(1, pageList.getTotalPages());
    }



    @Test
    void shouldFindCustomerByIdSuccess() {
        when(customerRepository.findCustomerById(anyLong())).thenReturn(getCustomer());
        var customer = customerUseCase.findCustomerById(1L);
        assertNotNull(customer);
    }

    @Test
    void shouldFindCustomerByEmailSuccess() {
        when(customerRepository.findCustomerByEmail(anyString())).thenReturn(getCustomer());
        var customer = customerUseCase.findCustomerByEmail("email@email.com");
        assertNotNull(customer);
    }

    @Test
    void shouldFindCustomerByUsernameSuccess() {
        when(customerRepository.findCustomerByUsername(anyString())).thenReturn(getCustomer());
        var customer = customerUseCase.findCustomerByUsername("usuario");
        assertNotNull(customer);
    }

    @Test
    void shouldSaveCustomerSuccess() {
        when(customerRepository.save(any(Customer.class))).thenReturn(new Customer().setId(1L));
        when(notificationUseCase.sendNotification(any(Customer.class))).thenReturn(getStatusSuccess());
        var customer = getCustomer();
        var status = customerUseCase.save(customer);
        verify(customerRepository, times(1)).save(any(Customer.class));
        verify(notificationUseCase, times(1)).sendNotification(any(Customer.class));
        assertNotNull(status);
    }

    @Test
    void shouldDeleteCustomerByIdSuccess() {
        var status = customerUseCase.delete(1L);
        assertNotNull(status);
        verify(customerRepository).delete(anyLong());
    }



}
