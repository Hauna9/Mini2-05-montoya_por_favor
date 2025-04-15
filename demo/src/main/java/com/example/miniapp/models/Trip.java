package com.example.miniapp.models;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime tripDate;
    private String origin;
    private String destination;
    private double tripCost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "captain_id")
    @JsonBackReference
    private Captain captain;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    public Trip() {
    }

    public Trip(LocalDateTime tripDate, String origin, String destination, double tripCost) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }

    public Trip(LocalDateTime tripDate, String origin, String destination, double tripCost, Captain captain, Customer customer) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
        this.captain = captain;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }
    public LocalDateTime getTripDate() {
        return tripDate;
    }
    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public double getTripCost() {
        return tripCost;
    }
    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }
}
