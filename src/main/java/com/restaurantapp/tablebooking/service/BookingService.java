package com.restaurantapp.tablebooking.service;

import com.restaurantapp.tablebooking.domain.Booking;

public interface BookingService {
    public Booking create(Booking booking) throws Exception;
}
