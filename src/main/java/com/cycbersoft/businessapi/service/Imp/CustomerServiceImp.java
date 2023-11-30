package com.cycbersoft.businessapi.service.Imp;

import com.cycbersoft.businessapi.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceImp {

    List<CustomerEntity> findAll();
    CustomerEntity findById(int id);
    boolean insert(CustomerEntity customer);

    boolean update (CustomerEntity customer);
    boolean deleteById(int id);

}
