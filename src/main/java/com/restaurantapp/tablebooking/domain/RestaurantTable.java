package com.restaurantapp.tablebooking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tableNo;
    private int seat;

    @JsonIgnoreProperties("restaurantTables")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "restaurant_tables_bookings",
            joinColumns = {@JoinColumn(name = "table_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="booking_id", nullable = false, updatable = false)}
    )
    private List<Booking> bookings;
    public RestaurantTable(int tableNo, int seat) {
        this.tableNo = tableNo;
        this.seat = seat;
        this.bookings = new ArrayList<>();

    }
    public boolean isAvailableOnDate(String dateString){
        for (Booking booking : bookings)
            if (LocalDate.parse(dateString).equals(booking.getBdate())) return false;
        return true;
    }

}
