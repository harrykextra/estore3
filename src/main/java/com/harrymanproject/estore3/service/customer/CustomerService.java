package com.harrymanproject.estore3.service.customer;

import com.harrymanproject.estore3.data.exception.CustomerException;
import com.harrymanproject.estore3.data.model.Customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer) throws CustomerException;
    void updateCustomer(Customer customer) throws CustomerException;
    Customer findCustomerById(Integer id);
    List<Customer> findAllCustomers();
    void deleteCustomerById(Integer id);
}
