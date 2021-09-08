package com.harrymanproject.estore3.service.customer;

import com.harrymanproject.estore3.data.exception.CustomerException;
import com.harrymanproject.estore3.data.model.Customer;
import com.harrymanproject.estore3.data.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService = new CustomerServiceImpl();
    Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
    }

    @Test
    void saveCustomerTest() throws CustomerException{
        customerService.saveCustomer(customer);
        verify(customerRepository, times(1)).saveCustomer(customer);
    }

    @Test
    void updateCustomerTest() throws CustomerException{
        customer.setId(2);
        customer.setFirstName("Chuka");
        when(customerRepository.findById(2)).thenReturn(Optional.of(customer));
        customerService.updateCustomer(customer);
        verify(customerRepository, times(2));
    }

    @Test
    void findCustomerByIdTest(){
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        customerService.findCustomerById(1);
        verify(customerRepository, times(1)).findById(1);
    }

    @Test
    void findAllCustomersTest(){
        when(customerRepository.findAll()).thenReturn(List.of(customer));
        customerService.findAllCustomers();
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void deleteCustomerByIdTest(){
        customerService.deleteCustomerById(1);
        verify(customerRepository, times(1)).deleteById(1);
    }
}