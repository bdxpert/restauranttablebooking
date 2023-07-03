package com.restaurantapp.tablebooking.service.impl;

import com.restaurantapp.tablebooking.domain.Customer;
import com.restaurantapp.tablebooking.repository.CustomerRepository;
import com.restaurantapp.tablebooking.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
