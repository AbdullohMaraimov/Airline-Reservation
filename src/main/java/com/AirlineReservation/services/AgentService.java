package com.AirlineReservation.services;

import com.AirlineReservation.models.dtos.CreateFlightDto;
import com.AirlineReservation.models.entities.Flight;

public interface AgentService {

    String createFlight(Integer agentId, CreateFlightDto dto);

    String sendNotificationToCustomers(Flight flight);

    String updateFlight(CreateFlightDto dto, Integer flightId);
}
