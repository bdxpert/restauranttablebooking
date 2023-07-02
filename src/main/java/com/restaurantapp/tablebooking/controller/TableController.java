package com.restaurantapp.tablebooking.controller;

import com.restaurantapp.tablebooking.exception.ApiRequestException;
import com.restaurantapp.tablebooking.repository.RestaurantTableRepository;
import com.restaurantapp.tablebooking.service.RestaurantTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.restaurantapp.tablebooking.utils.AppConstant.SUCCESS;

@RestController
@RequestMapping(value = "/restaurant-tables", name = "RestaurantTableController")
public class TableController extends BaseController {

    private RestaurantTableRepository restaurantTableRepository;
    private RestaurantTableService restaurantTableService;

    public TableController(RestaurantTableRepository restaurantTableRepository, RestaurantTableService restaurantTableService) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.restaurantTableService = restaurantTableService;
    }

    @GetMapping
    public ResponseEntity<?> getAllRestaurantTables() {
        try {
            return getResponse(SUCCESS, restaurantTableRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch restaurant tables by seat number", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/seat/{number}")
    public ResponseEntity<?> getTablesBySeating(@PathVariable int number) {
        try {
            return getResponse(SUCCESS, restaurantTableRepository.findRestaurantTablesBySeat(number), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch restaurant tables by seat number", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/available-on-date/{date}")
    public ResponseEntity<?> getTablesAvailableOnDate(@PathVariable String date) {
        try {
            return getResponse(SUCCESS, restaurantTableService.getTablesAvailableOnDate(date), HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch restaurant tables by date", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}