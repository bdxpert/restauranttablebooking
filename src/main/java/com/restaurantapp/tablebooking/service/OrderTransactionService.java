package com.restaurantapp.tablebooking.service;

import com.restaurantapp.tablebooking.domain.OrderTransaction;

import java.time.LocalDate;
import java.util.List;

public interface OrderTransactionService {
    List<OrderTransaction> findAll();
    List<OrderTransaction> findAllTransactionsByDate(LocalDate localDate);
    List<OrderTransaction> getTransactionsByBookingId(Long bookingId);
    List<OrderTransaction> getTransactionsByCustomerId(Long customerId);
    OrderTransaction create(OrderTransaction orderTransaction);
}
