package org.example.controller;

import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class customerController {
    @Autowired
    CustomerService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @GetMapping("/get")
    public Iterable<CustomerEntity>getCustomer(){
        return service.getCustomer();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCustomer(@PathVariable Long id){
        service.deleteCustomer(id);
        return "Deleted";
    }

    @GetMapping("search/{id}")
    public Customer getBookById(@PathVariable Long id){
        return service.getCustomerById(id);
    }
}
