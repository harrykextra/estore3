package com.harrymanproject.estore3.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    @ManyToMany(mappedBy = "addresses")
    @ToString.Exclude
    private List<Customer> customers;

    public void setCustomers(Customer customer){
        if (customers == null){
            customers = new ArrayList<>();
        }
        customers.add(customer);
    }
}
