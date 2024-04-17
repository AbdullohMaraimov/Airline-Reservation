package com.AirlineReservation.services.impl;

import com.AirlineReservation.models.entities.*;
import com.AirlineReservation.repositories.*;
import com.AirlineReservation.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CityRepository cityRepository;
    private final AirportRepository airportRepository;
    private final AgentRepository agentRepository;
    private final FlightRepository flightRepository;
    private final CustomerRepository customerRepository;

    @Override
    public String addCity(City city) {
        cityRepository.save(city);
        return "City added successfully";
    }

    @Override
    public String deleteCity(City city) {
        cityRepository.delete(city);
        return "City deleted Successfully!";
    }

    @Override
    public String addAirport(Airport airport) {
        airportRepository.save(airport);
        return "Added";
    }

    @Override
    public String deleteAirport(Airport airport) {
        airportRepository.delete(airport);
        return "Deleted";
    }

    @Override
    public String addAgent(Agent agent) {
        agentRepository.save(agent);
        return "Added";
    }

    @Override
    public String deleteAgent(Agent agent) {
        agentRepository.delete(agent);
        return "Deleted";
    }

    @Override
    public String deleteCustomers(Customer customer) {
        List<Flight> bookedFlights = customer.getBookedFlights();
        List<Airport> airports = airportRepository.findAll();

        for (Airport airport : airports) {
            for (Flight flight : airport.getFlights()) {
                for (Customer customerInFlight : flight.getCustomer()) {
                    if (customerInFlight.getId() == customer.getId()) {
                        flight.getCustomer().remove(customerInFlight);
                        flightRepository.save(flight);
                    }
                }
            }
        }
        customerRepository.delete(customer);
        return "Deleted";
    }
}
