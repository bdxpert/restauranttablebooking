package com.restaurantapp.tablebooking.controller;

import com.restaurantapp.tablebooking.domain.Customer;
import com.restaurantapp.tablebooking.exception.ApiRequestException;
import com.restaurantapp.tablebooking.repository.CustomerRepository;
import com.restaurantapp.tablebooking.service.CustomerService;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.restaurantapp.tablebooking.utils.AppConstant.SUCCESS;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomer() {
        try {
            return getResponse(SUCCESS, customerService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch all customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
        @GetMapping(value = "/name/{name}")
        public ResponseEntity<?> getCustomerByName(@PathVariable String name) {
            try {
                return getResponse(SUCCESS, customerRepository.findCustomerByName(name), HttpStatus.OK);
            } catch (Exception e) {
                throw new ApiRequestException("Unable to fetch all customer", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?>  getCustomerById(@PathVariable Long id) {
        try {
            return getResponse(SUCCESS, customerService.findCustomerById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        try {
            //TODO create customer
            return getResponse(SUCCESS, customerService.create(customer), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        try {
            return getResponse(SUCCESS, customerService.update(customer), HttpStatus.OK);
        }  catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
