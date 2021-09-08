package com.harrymanproject.estore3.data.repository;

import com.harrymanproject.estore3.data.exception.CustomerException;
import com.harrymanproject.estore3.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    default Customer saveCustomer (Customer customer) throws CustomerException{
        if (!customerHasEmail(customer)){
            throw new CustomerException("Email address can not be null");
        }else if (!customerHasPassword(customer)){
            throw new CustomerException("Password is required");
        }else if (!customerHasFullName(customer)){
            throw new CustomerException("Full name required");
        }
        return save(customer);
    }

    private boolean customerHasEmail(Customer customer){
        return customer.getEmail() != null;
    }

    private boolean customerHasPassword(Customer customer){
        return customer.getPassword() != null;
    }

    private boolean customerHasFullName (Customer customer){
        return customer.getFirstName() != null  && customer.getLastName() != null;
    }
}
