package org.example.service.impl;

import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;


    ModelMapper mapper;
    @Bean
    public void setup(){
        this.mapper = new ModelMapper();
    }
    @Override
    public void addCustomer(Customer customer) {
        CustomerEntity entity = mapper.map(customer, CustomerEntity.class);
        repository.save(entity);

    }
}
