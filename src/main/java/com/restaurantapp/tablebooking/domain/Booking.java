package com.restaurantapp.tablebooking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate bdate;
    private LocalTime startTime;
    private int personCount;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnoreProperties("bookings")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "table_id", nullable = false, updatable = false)}
    )
    private List<RestaurantTable> restaurantTables;

    @JsonIgnore
    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<OrderTransaction> orderTransactions;

    public Booking(Customer customer, LocalDate bookingDate, LocalTime startTime, int numberInParty, String notes, List<RestaurantTable> restaurantTables) {
        this.bdate = bookingDate;
        this.startTime = startTime;
        this.personCount = numberInParty;
        this.notes = notes;
        this.customer = customer;
        this.restaurantTables = restaurantTables;
        this.orderTransactions = new ArrayList<>();
    }
}
