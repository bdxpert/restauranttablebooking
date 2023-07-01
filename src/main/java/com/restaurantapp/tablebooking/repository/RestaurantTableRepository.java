package com.restaurantapp.tablebooking.repository;

import com.restaurantapp.tablebooking.domain.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    List<RestaurantTable> findRestaurantTablesBySeat(int number);
    List<RestaurantTable> findAll();
}