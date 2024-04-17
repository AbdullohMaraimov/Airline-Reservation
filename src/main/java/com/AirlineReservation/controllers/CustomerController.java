package com.AirlineReservation.controllers;

import com.AirlineReservation.models.dtos.RegisterCustomerDto;
import com.AirlineReservation.models.entities.Customer;
import com.AirlineReservation.models.entities.Flight;
import com.AirlineReservation.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@Tag(name = "Customer controller")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(
            summary = "This endpoint registers customers",
            description = "This endpoint registers customers"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully registered customer"
            )
    })
    @PostMapping("/register")
    public String register(@RequestBody RegisterCustomerDto dto) {
        return customerService.register(dto);
    }

    @Operation(
            summary = "This endpoint gets customers",
            description = "This endpoint gets customers"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully got customers"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found exception"
            )
    })
    @GetMapping("/{id}")
    public Customer getCustomerById(@RequestParam Integer id) {
        return customerService.getCustomerById(id);
    }

    @Operation(
            summary = "This endpoint gets the list of customers",
            description = "This endpoint gets the list of customers"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully got customers"
            )
    })
    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @Operation(
            summary = "This endpoint gets the list of customers",
            description = "This endpoint gets the list of customers"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully deleted"
            )
    })
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@RequestParam Integer id) {
        return customerService.deleteById(id);
    }


    @Operation(
            summary = "This endpoint gets the list of available flights",
            description = "This endpoint gets the list of available flights"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully got flights"
            )
    })
    @GetMapping("/flights")
    public List<Flight> getAllFlights(@RequestParam Integer airportId) {
        return customerService.checkAvailableFlights(airportId);
    }

}


