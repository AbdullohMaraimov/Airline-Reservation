package com.AirlineReservation.controllers;

import com.AirlineReservation.models.entities.Agent;
import com.AirlineReservation.models.entities.Airport;
import com.AirlineReservation.models.entities.City;
import com.AirlineReservation.repositories.AgentRepository;
import com.AirlineReservation.repositories.AirportRepository;
import com.AirlineReservation.repositories.CityRepository;
import com.AirlineReservation.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@Tag(name = "Admin controller", description = "This api is for admin to controller everything")
public class AdminController {

    private final CityRepository cityRepository;
    private final AgentRepository agentRepository;
    private final AdminService adminService;
    private final AirportRepository airportRepository;

    @Operation(
            summary = "This endpoint creates city",
            description = "This endpoint creates city"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully created city"
            )
    })
    @PostMapping("/city")
    public String addCity(@RequestBody City city) {
        cityRepository.save(city);
        return "City Added!";
    }

    @Operation(
            summary = "This endpoint gets  city",
            description = "This endpoint gets city"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully got city"
            )
    })
    @GetMapping("/city")
    public List<City> cities() {
        return cityRepository.findAll();
    }


    @Operation(
            summary = "This endpoint gets the list of city",
            description = "This endpoint gets the list of city"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully got city"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found exception"
            )
    })
    @DeleteMapping("/city/{id}")
    public String deleteCity(@PathVariable Integer id) {
        cityRepository.deleteById(id);
        return "City deleted successfully";
    }


    @Operation(
            summary = "This endpoint creates agent",
            description = "This endpoint creates agent"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully created agent"
            )
    })
    @PostMapping("/agent")
    public String addAgent(@RequestBody Agent agent) {
        agentRepository.save(agent);
        return "Agent Added!";
    }

    @Operation(
            summary = "This endpoint gets  agents",
            description = "This endpoint gets agents"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully got agents"
            )
    })
    @GetMapping("/agent")
    public List<Agent> agents() {
        return agentRepository.findAll();
    }

    @Operation(
            summary = "This endpoint deletes agent",
            description = "This endpoint deletes agent"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found exception"
            )
    })
    @DeleteMapping("/agent/{id}")
    public String deleteAgent(@PathVariable Integer id) {
        agentRepository.deleteById(id);
        return "Agent deleted successfully";
    }

    @Operation(
            summary = "This endpoint creates airport",
            description = "This endpoint creates airport"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully created airport"
            )
    })
    @PostMapping("/airport")
    public String addAirport(@RequestBody Airport airport) {
        return adminService.addAirport(airport);
    }


    @Operation(
            summary = "This endpoint deletes airport",
            description = "This endpoint deletes airport"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found exception"
            )
    })
    @DeleteMapping("/airport/{id}")
    public String deleteAirport(@PathVariable Integer id) {
        Airport airport = airportRepository.findById(id).get();
        return adminService.deleteAirport(airport);
    }


    @Operation(
            summary = "This endpoint gets  airport",
            description = "This endpoint gets airport"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully got airport"
            )
    })
    @GetMapping("/airport")
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

}
