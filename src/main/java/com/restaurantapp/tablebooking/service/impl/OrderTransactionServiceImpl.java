package com.restaurantapp.tablebooking.service.impl;

import com.restaurantapp.tablebooking.domain.OrderTransaction;
import com.restaurantapp.tablebooking.repository.OrderTransactionRepository;
import com.restaurantapp.tablebooking.service.OrderTransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderTransactionServiceImpl implements OrderTransactionService {
    private OrderTransactionRepository transactionRepository;

    public OrderTransactionServiceImpl(OrderTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<OrderTransaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public List<OrderTransaction> findAllTransactionsByDate(LocalDate localDate) {
        return transactionRepository.findAllTransactionsByDate(localDate);
    }

    @Override
    public List<OrderTransaction> getTransactionsByBookingId(Long bookingId) {
        return transactionRepository.getTransactionsByBookingId(bookingId);
    }

    @Override
    public List<OrderTransaction> getTransactionsByCustomerId(Long customerId) {
        return transactionRepository.getTransactionsByCustomerId(customerId);
    }
}
