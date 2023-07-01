package com.restaurantapp.tablebooking.repository;

import com.restaurantapp.tablebooking.domain.OrderTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderTransactionRepository  extends JpaRepository<OrderTransaction, Long> {
    List<OrderTransaction> getTransactionsByCustomerId(Long customerId);
    List<OrderTransaction> getTransactionsByBookingId(Long bookingId);
    List<OrderTransaction> getTransactionsByCustomerName(String customerName);
    List<OrderTransaction> findAllTransactionsByDate(LocalDate date);
}

