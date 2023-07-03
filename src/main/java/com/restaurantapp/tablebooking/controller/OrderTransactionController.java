package com.restaurantapp.tablebooking.controller;

import com.restaurantapp.tablebooking.domain.OrderTransaction;
import com.restaurantapp.tablebooking.exception.ApiRequestException;
import com.restaurantapp.tablebooking.repository.OrderTransactionRepository;
import com.restaurantapp.tablebooking.service.OrderTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import static com.restaurantapp.tablebooking.utils.AppConstant.SUCCESS;

@RestController
@RequestMapping("/transactions")
public class OrderTransactionController extends BaseController {

    private OrderTransactionService transactionService;

    public OrderTransactionController(OrderTransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping
    public ResponseEntity<?> getOrders() {
        try {
            List<OrderTransaction> orderTransactions = transactionService.findAll();
            return getResponse(SUCCESS, orderTransactions, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/date/{date}")
    public ResponseEntity<?> getAllTransactionsForDate(@PathVariable String date) {
        try {
            LocalDate getDate = LocalDate.parse(date);
            return getResponse(SUCCESS, transactionService.findAllTransactionsByDate(getDate), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch transaction by date", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/booking/{bookingId}")
    public ResponseEntity<?> getTransactionsByBookingId(@PathVariable Long bookingId) {
        try {
            return getResponse(SUCCESS, transactionService.getTransactionsByBookingId(bookingId), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch transaction by booking id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/customer/{customerId}")
    public ResponseEntity<?> getTransactionsByCustomerId(@PathVariable Long customerId) {
        try {
            return getResponse(SUCCESS, transactionService.getTransactionsByCustomerId(customerId), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch transaction by customer id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @GetMapping(value="/customer-name/{customerName}")
    public List<OrderTransaction> getTransactionsByCustomerName(@PathVariable String customerName){
        return transactionRepository.getTransactionsByCustomerName(customerName);
    }*/
}