package com.AirlineReservation.models.dtos;

import lombok.Data;

@Data
public class LoginCustomerDto {
    private String email;
    private String password;
}
