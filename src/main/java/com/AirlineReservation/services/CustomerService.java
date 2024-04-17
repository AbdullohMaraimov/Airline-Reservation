package com.AirlineReservation.services;

import com.AirlineReservation.models.dtos.LoginCustomerDto;
import com.AirlineReservation.models.dtos.RegisterCustomerDto;
import com.AirlineReservation.models.entities.Airport;
import com.AirlineReservation.models.entities.Customer;
import com.AirlineReservation.models.entities.Flight;

import java.util.List;

public interface CustomerService {

    String register(RegisterCustomerDto dto);
    void login(LoginCustomerDto dto);

    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomer();

    String deleteById(Integer id);

    List<Flight> checkAvailableFlights(Integer airportId);
    String buyTicket(Integer id, Flight flight);
    String cancelTicket(Integer customerId, Integer flightId);

}
