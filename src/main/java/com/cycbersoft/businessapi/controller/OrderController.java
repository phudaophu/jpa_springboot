package com.cycbersoft.businessapi.controller;

import com.cycbersoft.businessapi.entity.OrderEntity;
import com.cycbersoft.businessapi.service.Imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;

    @GetMapping("find-all")
    public ResponseEntity<?> findAll(){
        List<OrderEntity> listOrders = orderServiceImp.findAll();
        return new ResponseEntity<>(listOrders, HttpStatus.OK);
    }
    @PostMapping("find-by-id")
    public ResponseEntity<?> findById(@RequestParam int id){
        OrderEntity order = orderServiceImp.findById(id);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity<?> insert(@RequestBody OrderEntity order){
        boolean check = orderServiceImp.insert(order);
        return new ResponseEntity<>(check,HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody OrderEntity order){
        boolean check = orderServiceImp.update(order);
        return new ResponseEntity<>(check,HttpStatus.OK);
    }
    @DeleteMapping("delete-by-id")
    public ResponseEntity<?> delete(@RequestParam int id){
        boolean check = orderServiceImp.deleteById(id);
        return new ResponseEntity<>(check,HttpStatus.OK);
    }
    @PostMapping("find-by-customer-id")
    public ResponseEntity<?> findByCustomerId(@RequestParam int customerId){
        List<OrderEntity> listOrders = orderServiceImp.findByCustomerId(customerId);
        return new ResponseEntity<>(listOrders,HttpStatus.OK);
    }

}
