package com.example.miniapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="captains")
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String license_number;
    private Double avg_rating_score;

    @JsonIgnore
    @OneToMany(mappedBy = "captain")
    private List<Trip> trips;

    //constructors
    public Captain() {

    }
    public Captain(String name, String license_number, Double avg_rating_score) {
        this.name = name;
        this.license_number = license_number;
        this.avg_rating_score = avg_rating_score;
    }
    public Captain(String name, String license_number, Double avg_rating_score, List<Trip> trips) {
        this.name = name;
        this.license_number = license_number;
        this.avg_rating_score = avg_rating_score;
        this.trips = trips;
    }
    public Captain(String name, String license_number, Double avg_rating_score, Trip trip){
        this.name = name;
        this.license_number = license_number;
        this.avg_rating_score = avg_rating_score;
        this.trips.add(trip);
    }

    //getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLicense_number() {
        return license_number;
    }
    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }
    public Double getAvg_rating_score() {
        return avg_rating_score;
    }
    public void setAvg_rating_score(Double avg_rating_score) {
        this.avg_rating_score = avg_rating_score;
    }
    public List<Trip> getTrips() {
        return trips;
    }
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }


}
