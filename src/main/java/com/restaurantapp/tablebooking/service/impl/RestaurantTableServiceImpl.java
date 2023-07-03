package com.restaurantapp.tablebooking.service.impl;

import com.restaurantapp.tablebooking.domain.RestaurantTable;
import com.restaurantapp.tablebooking.repository.RestaurantTableRepository;
import com.restaurantapp.tablebooking.service.RestaurantTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {
    private RestaurantTableRepository restaurantTableRepository;

    public RestaurantTableServiceImpl(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestaurantTable> getTablesAvailableOnDate(String date) {
        List<RestaurantTable> tableList = restaurantTableRepository.findAll();
        return tableList.stream().filter(table->table.isAvailableOnDate(date)).collect(Collectors.toList());
    }
}
