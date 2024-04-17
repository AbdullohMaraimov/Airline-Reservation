package com.AirlineReservation.services.impl;

import com.AirlineReservation.mappers.CustomerMapper;
import com.AirlineReservation.models.dtos.LoginCustomerDto;
import com.AirlineReservation.models.dtos.RegisterCustomerDto;
import com.AirlineReservation.models.entities.Airport;
import com.AirlineReservation.models.entities.Customer;
import com.AirlineReservation.models.entities.Flight;
import com.AirlineReservation.repositories.AirportRepository;
import com.AirlineReservation.repositories.CustomerRepository;
import com.AirlineReservation.repositories.FlightRepository;
import com.AirlineReservation.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    @Override
    public String register(RegisterCustomerDto dto) {
        customerRepository.save(customerMapper.toEntity(dto));
        return "Customer registered successfully";
    }

    @Override
    public void login(LoginCustomerDto dto) {

    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteById(Integer id) {
        customerRepository.deleteById(id);
        return "Deleted - " + id;
    }

    @Override
    public List<Flight> checkAvailableFlights(Integer airportId) {
        Optional<Airport> airport = airportRepository.findById(airportId);
        return flightRepository.checkAvailableFlights(airport.get());
    }

    @Override
    public String buyTicket(Integer id, Flight flight) {
        Customer customer = customerRepository.findById(id).get();

        customer.getBookedFlights().add(flight);
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);

        flight.getCustomer().add(customer);

        flightRepository.save(flight);

        return "Successfully booked!";
    }

    @Override
    public String cancelTicket(Integer customerId, Integer flightId) {

        Customer customer = customerRepository.findById(customerId).get();

        Flight flight = flightRepository.findById(flightId).get();
        customer.getBookedFlights().remove(flight);

        flight.getCustomer().remove(customer);

        customerRepository.save(customer);

        return "Cancelled successfully!";
    }
}
