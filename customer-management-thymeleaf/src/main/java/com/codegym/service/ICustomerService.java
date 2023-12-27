package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findALl();
    Customer findById(int id);
    void save(Customer customer);
    void update(int id, Customer customer);
    void remove(int id);
}
