package com.restaurantapp.tablebooking.service.impl;

import com.restaurantapp.tablebooking.domain.Customer;
import com.restaurantapp.tablebooking.repository.CustomerRepository;
import com.restaurantapp.tablebooking.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
