package com.cycbersoft.businessapi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;

}
