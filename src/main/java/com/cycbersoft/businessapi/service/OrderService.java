package com.cycbersoft.businessapi.service;

import com.cycbersoft.businessapi.entity.CustomerEntity;
import com.cycbersoft.businessapi.entity.OrderEntity;
import com.cycbersoft.businessapi.repository.CustomerRepository;
import com.cycbersoft.businessapi.repository.OrderRepository;
import com.cycbersoft.businessapi.service.Imp.OrderServiceImp;
import com.google.gson.Gson;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService implements OrderServiceImp {

    private Gson gson = new Gson();

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<OrderEntity> findAll() {

        return orderRepository.findAll();
    }

    @Override
    public OrderEntity findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public boolean insert(OrderEntity order) {
        boolean checkFlag = false;
        if(StringUtils.hasLength(order.getOrderCode())){
            orderRepository.saveAndFlush(order);
            checkFlag = true;
        }
        return checkFlag;
    }

    @Override
    public List<OrderEntity> findByCustomerId(int customerId) {
        List<OrderEntity> listOrders = new ArrayList<>();
        CustomerEntity checkedCustomer = customerRepository.findById(customerId);
        if (checkedCustomer != null){
            listOrders = orderRepository.findByCustomerId(customerId);
        }
        return listOrders;
    }

    @Override
    public boolean update(OrderEntity order) {
        boolean checkFlag = false;
        int checkedOrderId = order.getId();
        OrderEntity checkedOrder = orderRepository.findById(checkedOrderId);
        if(checkedOrder!=null){
            String jsonCheckedOrder = gson.toJson(checkedOrder);
            // Remove }} and then, compare string json to json
            String jsonOrder = gson.toJson(order).replace("}}","");
//            System.out.println(jsonCheckedOrder);
//            System.out.println(jsonOrder);
            if(!jsonCheckedOrder.contains(jsonOrder) && StringUtils.hasLength(order.getOrderCode())){
                orderRepository.saveAndFlush(order);
                checkFlag = true;
            }
        }
        return checkFlag;
    }

    @Override
    public boolean deleteById(int id) {
        boolean checkFlag = false;
        OrderEntity order = orderRepository.findById(id);
        if(order!=null){
            orderRepository.deleteById(order.getId());
            checkFlag=true;
        }
        return checkFlag;
    }

}
