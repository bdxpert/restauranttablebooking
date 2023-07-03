package com.restaurantapp.tablebooking.service;

import com.restaurantapp.tablebooking.domain.Booking;
import org.springframework.dao.DataAccessResourceFailureException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingService {
    public Booking create(Booking booking) throws Exception;
    public Booking update(Booking booking) throws DataAccessResourceFailureException;
    public Booking getById(Long bookingId) throws DataAccessResourceFailureException;
    public boolean deleteById(Long bookingId) throws DataAccessResourceFailureException;
    public List<Booking> getBookingsByCustomerId(Long customerId) throws DataAccessResourceFailureException;
    List<Booking> getBookingByBdateAndStartTimeAndCustomerId(LocalDate getDate, LocalTime getTime, Long customerId) throws DataAccessResourceFailureException;
    List<Booking> findAllBookingsByBdate(LocalDate date) throws DataAccessResourceFailureException;
    List<Booking> findAll();
}
