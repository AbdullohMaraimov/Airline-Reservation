package com.AirlineReservation.repositories;

import com.AirlineReservation.models.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

    City findCityByName(String cityName);

}
