package com.restaurantapp.tablebooking.controller;

import com.restaurantapp.tablebooking.domain.Booking;
import com.restaurantapp.tablebooking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.restaurantapp.tablebooking.exception.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.restaurantapp.tablebooking.utils.AppConstant.ERROR;
import static com.restaurantapp.tablebooking.utils.AppConstant.SUCCESS;

@RestController
@RequestMapping("/bookings")
public class BookingController extends BaseController {

    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<?> getBookings() {
        try {
            List<Booking> bookings = bookingService.findAll();
            return getResponse(SUCCESS, bookings, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch all booking", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/date/{date}")
    public ResponseEntity<?> getAllBookingsForDate(@PathVariable String date) {
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            List<Booking> bookings = bookingService.findAllBookingsByBdate(parsedDate);
            return getResponse(SUCCESS, bookings, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch booking by date", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/date/{date}/time/{time}/customer/{customerId}")
    public ResponseEntity<?> getBookingByDateTimeAndCustomerId(@PathVariable String date, @PathVariable String time, @PathVariable Long customerId) {
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            LocalTime parsedTime = LocalTime.parse(time);
            List<Booking> bookings = bookingService.getBookingByBdateAndStartTimeAndCustomerId(parsedDate, parsedTime, customerId);

            return getResponse(SUCCESS, bookings, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch booking by date time and customer id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/customer/{customerId}")
    public ResponseEntity<?> getBookingsByCustomerId(@PathVariable Long customerId) {
        try {
            List<Booking> bookings = bookingService.getBookingsByCustomerId(customerId);

            return getResponse(SUCCESS, bookings, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Unable to fetch booking by customer id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{bookingId}")
    public ResponseEntity<?> deleteBookingById(@PathVariable Long bookingId) {
        try {
            bookingService.deleteById(bookingId);
            return getResponse(SUCCESS, "Booking deleted Successfully", HttpStatus.OK);
        } catch (NullPointerException e) {
            throw new ApiRequestException("Booking with id " + bookingId + " not found!", HttpStatus.NOT_FOUND);
        }  catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Booking createdBooking = bookingService.create(booking);
            return getResponse(SUCCESS, createdBooking, HttpStatus.OK);
        }  catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{bookingId}")
    public ResponseEntity<?> updateBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
        try {
            Booking existingBooking = bookingService.getById(bookingId);
            if(existingBooking != null) {
                Booking updatedBooking = bookingService.update(booking);
                return getResponse(SUCCESS, updatedBooking, HttpStatus.OK);
            } else
                return getResponse(ERROR, new Object(), HttpStatus.NOT_FOUND);
        }  catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}