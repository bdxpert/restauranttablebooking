package com.restaurantapp.tablebooking.repository;

import com.restaurantapp.tablebooking.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByName(String name);
    List<Customer> findAll();

    Customer findCustomerById(Long id);

}