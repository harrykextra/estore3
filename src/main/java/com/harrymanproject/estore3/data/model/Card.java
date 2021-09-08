package com.harrymanproject.estore3.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardName;
    private String cardType;
    private String expDate;
    private Integer cvv;
    private String cardNumber;

    @ManyToOne
    @ToString.Exclude
    private Customer customer;

    public void setCustomer(Customer customer){
        if (getCustomer() == null){
            this.customer = customer;
        }
    }
}
