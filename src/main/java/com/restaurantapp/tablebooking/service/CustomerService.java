package com.restaurantapp.tablebooking.service;

import com.restaurantapp.tablebooking.domain.Customer;

import java.util.List;

public interface CustomerService {
    public Customer create(Customer customer);
    public Customer update(Customer customer);
    public Customer findCustomerById(Long id);
    public List<Customer> findAll();
}
