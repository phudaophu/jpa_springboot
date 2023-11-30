package com.cycbersoft.businessapi.repository;

import com.cycbersoft.businessapi.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

    @Override
    List<CustomerEntity> findAll();

    CustomerEntity findById(int id);

    @Override
    <S extends CustomerEntity> S saveAndFlush(S entity);


    void deleteById(int id);

}
