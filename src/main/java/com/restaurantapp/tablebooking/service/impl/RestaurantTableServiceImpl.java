package com.restaurantapp.tablebooking.service.impl;

import com.restaurantapp.tablebooking.domain.Booking;
import com.restaurantapp.tablebooking.domain.RestaurantTable;
import com.restaurantapp.tablebooking.repository.BookingRepository;
import com.restaurantapp.tablebooking.repository.RestaurantTableRepository;
import com.restaurantapp.tablebooking.service.RestaurantTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {
    private RestaurantTableRepository restaurantTableRepository;
    private BookingRepository bookingRepository;

    public RestaurantTableServiceImpl(RestaurantTableRepository restaurantTableRepository,BookingRepository bookingRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestaurantTable> getTablesAvailableOnDate(String date) {
        List<RestaurantTable> tableList = restaurantTableRepository.findAll();
        List<RestaurantTable> bookedTables = bookedOnDateTables(date);
        return tableList.stream().filter(table->!bookedTables.contains(table)).collect(Collectors.toList());
    }
    @Override
    public List<RestaurantTable> bookedOnDateTables(String date) {
        List<Booking> bookings = bookingRepository.findAllBookingsByBdate(LocalDate.parse(date));
        return bookings.stream().map(Booking::getRestaurantTables).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
