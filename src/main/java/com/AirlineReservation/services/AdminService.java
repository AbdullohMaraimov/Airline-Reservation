package com.AirlineReservation.services;

import com.AirlineReservation.models.entities.Agent;
import com.AirlineReservation.models.entities.Airport;
import com.AirlineReservation.models.entities.City;
import com.AirlineReservation.models.entities.Customer;

public interface AdminService {

    String addCity(City city);
    String deleteCity(City city);

    String addAirport(Airport airport);
    String deleteAirport(Airport airport);

    String addAgent(Agent agent);
    String deleteAgent(Agent agent);

    String deleteCustomers(Customer customer);

}
