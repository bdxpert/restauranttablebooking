package com.restaurantapp.tablebooking.service;

import com.restaurantapp.tablebooking.domain.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {
    List<RestaurantTable> getTablesAvailableOnDate(String date);
}
