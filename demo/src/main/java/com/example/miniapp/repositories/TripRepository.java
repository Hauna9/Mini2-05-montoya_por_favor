package com.example.miniapp.repositories;

import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    //Retrieving trips within a specified date range.
    @Query("SELECT t FROM Trip t WHERE t.tripDate BETWEEN :startDate AND :endDate")
    List<Trip> findTripsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    // Custom query to find trips by captain ID
    @Query("SELECT t FROM Trip t WHERE t.captain.id = :captainId")
    List<Trip> findTripsByCaptainId(@Param("captainId") Long captainId);
}
