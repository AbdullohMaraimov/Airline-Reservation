package com.AirlineReservation.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private City fromCity;
    @ManyToOne
    private City destination;
    private Double ticketPrice;
    private LocalDateTime localDateTime;

    @JsonIgnore
    @ManyToMany
    private List<Customer> customer;
    private Integer availableSeats;

    @ManyToOne
    private Airport airport;

}
