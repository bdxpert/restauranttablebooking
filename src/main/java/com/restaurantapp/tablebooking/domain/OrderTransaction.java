package com.restaurantapp.tablebooking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class OrderTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private double paidAmount;
    private double dueAmount;

    private double balance = 0.0;

    private String notes;
    @JsonIgnoreProperties("booking")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    @JsonIgnoreProperties({"customer", "restaurantTables"})
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = true)
    private Booking booking;

    public OrderTransaction(LocalDate date, double dueAmount, double paidAmount, String notes, Customer customer, Booking booking){
        this.date = date;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.notes = notes;
        this.customer = customer;
        this.booking = booking;
        setBalance(calculateBalance());
    }
    public double calculateBalance(){
        double balance = paidAmount - dueAmount;
        return balance;
    }
}
