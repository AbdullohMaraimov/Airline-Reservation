package com.AirlineReservation.mappers;

import com.AirlineReservation.models.dtos.CreateFlightDto;
import com.AirlineReservation.models.entities.City;
import com.AirlineReservation.models.entities.Flight;
import com.AirlineReservation.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class FlightMapper {


    private final CityRepository cityRepository;

    public Flight toFlight(CreateFlightDto dto) {
        Flight flight = new Flight();
        flight.setAvailableSeats(dto.getAvailableSeats());
        flight.setTicketPrice(dto.getTicketPrice());

        String stringTime = dto.getLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime time = LocalDateTime.parse(stringTime, dateTimeFormatter);
        flight.setLocalDateTime(time);

        City fromCity = cityRepository.findCityByName(dto.getFromCity());
        flight.setFromCity(fromCity);

        City destination = cityRepository.findCityByName(dto.getDestination());
        flight.setDestination(destination);
        return flight;
    }

    public Flight updateFlight(Flight flight, CreateFlightDto dto) {

        flight.setAvailableSeats(dto.getAvailableSeats());
        flight.setTicketPrice(dto.getTicketPrice());

        String stringTime = dto.getLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime time = LocalDateTime.parse(stringTime, dateTimeFormatter);
        flight.setLocalDateTime(time);

        City fromCity = cityRepository.findCityByName(dto.getFromCity());
        flight.setFromCity(fromCity);

        City destination = cityRepository.findCityByName(dto.getDestination());
        flight.setDestination(destination);
        return flight;

    }
}
