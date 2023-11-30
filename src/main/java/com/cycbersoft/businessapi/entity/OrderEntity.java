package com.cycbersoft.businessapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Entity(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="order_code")
    private String orderCode;
    @Column(name="total_amount")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;
}
