package com.cycbersoft.businessapi.service.Imp;

import com.cycbersoft.businessapi.entity.OrderEntity;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface OrderServiceImp {
    List<OrderEntity> findAll();
    OrderEntity findById(int id);
    boolean insert(OrderEntity order);
    List<OrderEntity> findByCustomerId(int customerId);

    boolean update(OrderEntity order);
    boolean deleteById (int id);

}
