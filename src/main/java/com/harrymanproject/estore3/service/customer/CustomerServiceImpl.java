package com.harrymanproject.estore3.service.customer;

import com.harrymanproject.estore3.data.exception.AddressException;
import com.harrymanproject.estore3.data.exception.CustomerException;
import com.harrymanproject.estore3.data.model.Customer;
import com.harrymanproject.estore3.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) throws CustomerException {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerException {
        if (customer.getId() == null){
            throw new CustomerException("Id cannot be null");
        }

        Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);

        if (customer1 == null){
            throw new CustomerException("Customer does not exist");
        }
        if (customer.getFirstName() != null){
            customer1.setFirstName(customer.getFirstName());
        }
        if (customer.getLastName() != null){
            customer1.setLastName(customer.getLastName());
        }
        if (customer.getPassword() != null){
            customer1.setPassword(customer.getPassword());
        }
        if (customer.getEmail() != null){
            customer1.setEmail(customer.getEmail());
        }
        if (customer.getContact() != null){
            customer1.setContact(customer.getContact());
        }
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }
}
