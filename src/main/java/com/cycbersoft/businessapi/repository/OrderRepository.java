package com.cycbersoft.businessapi.repository;

import com.cycbersoft.businessapi.entity.OrderEntity;
import jakarta.persistence.criteria.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    @Override
    List<OrderEntity> findAll();

    OrderEntity findById(int id);

    @Override
    <S extends OrderEntity> S saveAndFlush(S entity);

    List<OrderEntity> findByCustomerId(int customerId);

    void deleteById(int id);
}
