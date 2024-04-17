package com.AirlineReservation.mappers;

import com.AirlineReservation.models.dtos.RegisterCustomerDto;
import com.AirlineReservation.models.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(RegisterCustomerDto dto) {
        return Customer.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

}
