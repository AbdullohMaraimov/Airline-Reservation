package com.AirlineReservation.services.impl;

import com.AirlineReservation.mappers.FlightMapper;
import com.AirlineReservation.models.dtos.CreateFlightDto;
import com.AirlineReservation.models.entities.Airport;
import com.AirlineReservation.models.entities.Customer;
import com.AirlineReservation.models.entities.Flight;
import com.AirlineReservation.repositories.AgentRepository;
import com.AirlineReservation.repositories.AirportRepository;
import com.AirlineReservation.repositories.FlightRepository;
import com.AirlineReservation.services.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final AgentRepository agentRepository;
    private final AirportRepository airportRepository;
    private final MailSenderService mailSenderService;

    @Override
    public String createFlight(Integer airportId, CreateFlightDto createFlightDto) {
        Flight flight = flightMapper.toFlight(createFlightDto);

        Airport airport = airportRepository.findById(airportId).get();
        airport.getFlights().add(flight);
        flightRepository.save(flight);

        return "Created";
    }

    @Override
    public String updateFlight(CreateFlightDto dto, Integer flightId) {

        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight with id %s not found".formatted(flightId)));

        flight = flightMapper.updateFlight(flight, dto);

        flightRepository.save(flight);

        mailSenderService.sendFreeMarkerMail(dto);

        return "Flight updated";
    }

//    private String sendUpdateNotification(Integer flightId) {
//
//        Flight flight = flightRepository.findById(flightId)
//                .orElseThrow(() -> new RuntimeException("Flight not foound"));
//
//        List<Customer> customers = flight.getCustomer();
//        for (Customer customer : customers) {
//
//        }
//
//        return "Notification messages are sent";
//    }

    @Override
    public String sendNotificationToCustomers(Flight flight) {
        for (Customer customer : flight.getCustomer()) {
            String email = customer.getEmail();
            System.out.println("Message to -> " + email);
        }
        return "";
    }
}
