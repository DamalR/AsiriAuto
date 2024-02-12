package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;


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

    @Override
    public List<CustomerEntity> getCustomer() {
        return (List<CustomerEntity>) repository.findAll();
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<CustomerEntity> byId = repository.findById(id);
        return mapper.map(byId,Customer.class);
    }
}
