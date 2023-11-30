package com.cycbersoft.businessapi.service;

import com.cycbersoft.businessapi.entity.CustomerEntity;
import com.cycbersoft.businessapi.entity.OrderEntity;
import com.cycbersoft.businessapi.repository.CustomerRepository;
import com.cycbersoft.businessapi.service.Imp.CustomerServiceImp;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceImp {

    private Gson gson= new Gson();
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> findAll(){
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean insert(CustomerEntity customer) {
        boolean checkFlag = false;
        // validate customer's name must not be null
        if (StringUtils.hasLength(customer.getName())){
            customerRepository.saveAndFlush(customer);
            checkFlag = true;
        }
        return checkFlag;
    }

    @Override
    public boolean update(CustomerEntity customer) {
        boolean checkFlag = false;
        int checkedCustomerId = customer.getId();
        CustomerEntity checkedCustomer = customerRepository.findById(checkedCustomerId);
        if(checkedCustomer!=null){
            String jsonCheckedCustomer = gson.toJson(checkedCustomer);
            // Remove }} and then, compare string json to json
            String jsonCustomer = gson.toJson(customer);
            System.out.println(jsonCheckedCustomer);
            System.out.println(jsonCustomer);
            if(!jsonCheckedCustomer.contains(jsonCustomer) && StringUtils.hasLength(customer.getName())){
                customerRepository.saveAndFlush(customer);
                checkFlag = true;
            }
        }
        return checkFlag;
    }

    @Override
    public boolean deleteById(int id) {
        boolean checkFlag = false;
        CustomerEntity checkedCustomer = customerRepository.findById(id);
        if (checkedCustomer!=null){
            customerRepository.deleteById(id);
            checkFlag = true;
        }
        return checkFlag;
    }

}
