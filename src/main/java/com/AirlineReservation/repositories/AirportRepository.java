package com.AirlineReservation.repositories;

import com.AirlineReservation.models.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
