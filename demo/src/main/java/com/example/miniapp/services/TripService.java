package com.example.miniapp.services;

import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip updateTrip(Long id, Trip trip) {
        Trip existingTrip = tripRepository.findById(id).orElse(null);
        if (existingTrip != null) {
            existingTrip.setTripDate(trip.getTripDate());
            existingTrip.setOrigin(trip.getOrigin());
            existingTrip.setDestination(trip.getDestination());
            existingTrip.setTripCost(trip.getTripCost());
            return tripRepository.save(existingTrip);
        }
        return null;
    }

    public void deleteTrip(Long id){
        tripRepository.deleteById(id);
    }

    public List<Trip> findTripsWithinDateRange(LocalDate startDate, LocalDate endDate){
        return tripRepository.findTripsByDateRange(startDate, endDate);
    }

    public List<Trip> findTripsByCaptainId(Long captainId){
        return tripRepository.findTripsByCaptainId(captainId);
    }
}
