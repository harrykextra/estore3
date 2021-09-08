package com.harrymanproject.estore3.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer quantity;
    private Double price;
    private String description;
    private String expDate;

    @JsonIgnore
    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Order> orders;
}
