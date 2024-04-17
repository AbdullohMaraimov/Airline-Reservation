package com.AirlineReservation.models.dtos;

import com.AirlineReservation.models.entities.City;
import lombok.Data;

@Data
public class RegisterCustomerDto {
    private String fullName;
    private String email;
    private String password;
}
