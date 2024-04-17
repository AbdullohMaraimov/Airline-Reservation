package com.AirlineReservation.repositories;

import com.AirlineReservation.models.entities.Airport;
import com.AirlineReservation.models.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("from Flight where availableSeats > 0 and airport = :airport")
    List<Flight> checkAvailableFlights(@Param("airport") Airport airport);

}
