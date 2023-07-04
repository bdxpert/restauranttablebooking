package com.restaurantapp.tablebooking.service;

import com.restaurantapp.tablebooking.domain.Booking;
import com.restaurantapp.tablebooking.domain.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {
    List<RestaurantTable> getTablesAvailableOnDate(String date);

    public List<RestaurantTable> bookedOnDateTables(String date);
}
