package com.example.miniapp.repositories;

import com.example.miniapp.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    @Query(value = "SELECT * FROM captains WHERE avg_rating_score > :ratingThreshold", nativeQuery = true)
    List<Captain> getCaptainsByRating(@Param("ratingThreshold") Double ratingThreshold);


    @Query(value = "SELECT * FROM captains WHERE license_number = :licenseNumber", nativeQuery = true)
    Captain getCaptainByLicenseNumber(@Param("licenseNumber") String licenseNumber);
}
