package com.AirlineReservation.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

//    @JsonIgnore
//    @OneToMany(mappedBy = "city")
//    private List<Airport> airport;

//    @OneToMany(mappedBy = "city")
//    private List<Customer> customer;
}
