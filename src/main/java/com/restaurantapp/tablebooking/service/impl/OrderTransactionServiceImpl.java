package com.restaurantapp.tablebooking.service.impl;

import com.restaurantapp.tablebooking.domain.OrderTransaction;
import com.restaurantapp.tablebooking.repository.OrderTransactionRepository;
import com.restaurantapp.tablebooking.service.OrderTransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderTransactionServiceImpl implements OrderTransactionService {
    private OrderTransactionRepository transactionRepository;

    public OrderTransactionServiceImpl(OrderTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderTransaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderTransaction> findAllTransactionsByDate(LocalDate localDate) {
        return transactionRepository.findAllTransactionsByDate(localDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderTransaction> getTransactionsByBookingId(Long bookingId) {
        return transactionRepository.getTransactionsByBookingId(bookingId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderTransaction> getTransactionsByCustomerId(Long customerId) {
        return transactionRepository.getTransactionsByCustomerId(customerId);
    }
}
