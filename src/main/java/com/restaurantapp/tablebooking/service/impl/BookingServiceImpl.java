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

import java.util.List;
@Slf4j
@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private RestaurantTableService restaurantTableService;

    public BookingServiceImpl(BookingRepository bookingRepository,RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
        this.bookingRepository = bookingRepository;
    }

    public Booking create(Booking booking) throws DataAccessResourceFailureException {
        //check booking already exists on given date
        List<Booking> bookingList = bookingRepository.findAllBookingsByBdate(booking.getBdate());
        List<Integer> tableNoList = booking.getRestaurantTables().stream().map(RestaurantTable::getTableNo).toList();
        Boolean isTableAvailable = true;
        for(Booking booking1: bookingList) {
            List<RestaurantTable> restaurantTables = booking1.getRestaurantTables();
            if(restaurantTables.stream().anyMatch(restaurantTable -> tableNoList.contains(restaurantTable.getTableNo()))) {
                isTableAvailable = false;
            }
        }

        if(isTableAvailable) {
            bookingRepository.save(booking);
            return booking;
        }
        throw new DataAccessResourceFailureException("Table already booked");
    }
}
