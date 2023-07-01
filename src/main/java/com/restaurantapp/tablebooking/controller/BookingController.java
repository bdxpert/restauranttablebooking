package com.restaurantapp.tablebooking.controller;

import com.restaurantapp.tablebooking.domain.Booking;
import com.restaurantapp.tablebooking.repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import com.restaurantapp.tablebooking.exception.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.restaurantapp.tablebooking.utils.AppConstant.SUCCESS;

@RestController
@RequestMapping("/bookings")
public class BookingController extends BaseController {

    private BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public ResponseEntity<?> getBookings() {
        try {
            List<Booking> bookings = bookingRepository.findAll();
            return getResponse(SUCCESS, bookings, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch booking by date", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/date/{date}")
    @CrossOrigin
    public ResponseEntity<?> getAllBookingsForDate(@PathVariable String date) {
        try {
            LocalDate getDate = LocalDate.parse(date);
            List<Booking> bookings = bookingRepository.findAllBookingsByBdate(getDate);
            return getResponse(SUCCESS, bookings, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch booking by date", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/date/{date}/time/{time}/customer/{customerId}")
    public ResponseEntity<?> getBookingByDateTimeAndCustomerId(@PathVariable String date, @PathVariable String time, @PathVariable Long customerId) {
        try {
            LocalDate getDate = LocalDate.parse(date);
            LocalTime getTime = LocalTime.parse(time);
            List<Booking> bookings = bookingRepository.getBookingByBdateAndBtimeAndCustomerId(getDate, getTime, customerId);

            return getResponse(SUCCESS, bookings, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch booking by date time and customer id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/customer/{customerId}")
    public ResponseEntity<?> getBookingsByCustomerId(@PathVariable Long customerId) {
        try {
            List<Booking> bookings = bookingRepository.getBookingsByCustomerId(customerId);

            return getResponse(SUCCESS, bookings, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch booking by customer id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{bookingId}")
    public ResponseEntity<?> deleteBookingById(@PathVariable Long bookingId) {
        try {
            bookingRepository.deleteById(bookingId);
        } catch (NullPointerException e) {
            throw new ApiRequestException("Booking with id " + bookingId + " not found!", HttpStatus.NOT_FOUND);
        } catch (DataAccessResourceFailureException e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return getResponse(SUCCESS, "Booking deleted Successfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        //TODO create booking
        try {
            return getResponse(SUCCESS, bookingRepository.save(booking), HttpStatus.OK);
        } catch (DataAccessResourceFailureException e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }


}