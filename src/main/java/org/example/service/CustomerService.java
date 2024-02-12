package org.example.service;

import org.example.dto.Customer;
import org.example.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    List<CustomerEntity> getCustomer();
}
