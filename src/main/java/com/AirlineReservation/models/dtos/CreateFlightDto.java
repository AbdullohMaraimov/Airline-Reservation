package com.AirlineReservation.models.dtos;

import lombok.Data;

@Data
public class CreateFlightDto {
    private String fromCity;
    private String destination;
    private Double ticketPrice;
    private String localDateTime;
    private Integer availableSeats;
}
