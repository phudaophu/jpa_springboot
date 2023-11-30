package com.cycbersoft.businessapi.controller;

import com.cycbersoft.businessapi.entity.CustomerEntity;
import com.cycbersoft.businessapi.service.CustomerService;
import com.cycbersoft.businessapi.service.Imp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImp customerServiceImp;

    @GetMapping("find-all")
    public ResponseEntity<?> findAll(){
        List<CustomerEntity> listCustomers = customerServiceImp.findAll();
        return new ResponseEntity<>(listCustomers, HttpStatus.OK);
    }
    @PostMapping("find-by-id")
    public ResponseEntity<?> findById(@RequestParam int id){
        CustomerEntity customer = customerServiceImp.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity<?> insert(@RequestBody CustomerEntity customer){
        boolean check = customerServiceImp.insert(customer);
        return new ResponseEntity<>(check,HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody CustomerEntity customer){
        boolean check = customerServiceImp.update(customer);
        return new ResponseEntity<>(check,HttpStatus.OK);
    }
    @DeleteMapping("delete-by-id")
    public ResponseEntity<?> deleteById (@RequestParam int id){
        boolean check = customerServiceImp.deleteById(id);
        return new ResponseEntity<>(check,HttpStatus.OK);
    }
}
