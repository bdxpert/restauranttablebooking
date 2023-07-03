package com.restaurantapp.tablebooking.service.impl;

import com.restaurantapp.tablebooking.domain.Booking;
import com.restaurantapp.tablebooking.domain.RestaurantTable;
import com.restaurantapp.tablebooking.exception.ApiRequestException;
import com.restaurantapp.tablebooking.repository.BookingRepository;
import com.restaurantapp.tablebooking.service.BookingService;
import com.restaurantapp.tablebooking.service.RestaurantTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private RestaurantTableService restaurantTableService;

    public BookingServiceImpl(BookingRepository bookingRepository, RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
        this.bookingRepository = bookingRepository;
    }

    public Booking getById(Long bookingId) throws DataAccessResourceFailureException {
        return bookingRepository.getById(bookingId);
    }

    public boolean deleteById(Long bookingId) throws DataAccessResourceFailureException {
        try {
            bookingRepository.deleteById(bookingId);
            return Boolean.TRUE;
        } catch (Exception ex) {
            log.error("Error occur while delete booking - {}", ex.getMessage());
        }
        return Boolean.FALSE;
    }

    public List<Booking> getBookingsByCustomerId(Long customerId) throws DataAccessResourceFailureException {
        List<Booking> bookings = bookingRepository.getBookingsByCustomerId(customerId);
        return bookings;
    }

    public List<Booking> getBookingByBdateAndStartTimeAndCustomerId(LocalDate date, LocalTime time, Long customerId) throws DataAccessResourceFailureException {
        List<Booking> bookings = bookingRepository.getBookingByBdateAndStartTimeAndCustomerId(date, time, customerId);
        return bookings;
    }

    public List<Booking> findAllBookingsByBdate(LocalDate date)  throws DataAccessResourceFailureException {
        return bookingRepository.findAllBookingsByBdate(date);
    }
    public List<Booking> findAll()
    {
        return bookingRepository.findAll();
    }

    public Booking create(Booking booking) throws DataAccessResourceFailureException {
        //check booking already exists on given date
        List<Booking> bookingList = bookingRepository.findAllBookingsByBdate(booking.getBdate());
        List<Integer> tableNoList = booking.getRestaurantTables().stream().map(RestaurantTable::getTableNo).toList();
        Boolean isTableAvailable = true;
        for (Booking booking1 : bookingList) {
            List<RestaurantTable> restaurantTables = booking1.getRestaurantTables();
            if (restaurantTables.stream().anyMatch(restaurantTable -> tableNoList.contains(restaurantTable.getTableNo()))) {
                isTableAvailable = false;
            }
        }

        if (isTableAvailable) {
            bookingRepository.save(booking);
            return booking;
        }
        throw new DataAccessResourceFailureException("Table already booked");
    }

    public Booking update(Booking booking) throws DataAccessResourceFailureException {
        //check booking already exists on given date
        List<Booking> bookingList = bookingRepository.findAllBookingsByBdate(booking.getBdate());
        List<Integer> tableNoList = booking.getRestaurantTables().stream().map(RestaurantTable::getTableNo).toList();
        Boolean isTableAvailable = true;
        for (Booking booking1 : bookingList) {
            if (booking1.getId() == booking.getId()) continue;
            List<RestaurantTable> restaurantTables = booking1.getRestaurantTables();
            if (restaurantTables.stream().anyMatch(restaurantTable -> tableNoList.contains(restaurantTable.getTableNo()))) {
                isTableAvailable = false;
            }
        }

        if (isTableAvailable) {
            bookingRepository.save(booking);
            return booking;
        }
        throw new DataAccessResourceFailureException("Table already booked");
    }
}
