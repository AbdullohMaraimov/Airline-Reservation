package com.AirlineReservation.controllers;

import com.AirlineReservation.models.dtos.CreateFlightDto;
import com.AirlineReservation.models.entities.Flight;
import com.AirlineReservation.repositories.FlightRepository;
import com.AirlineReservation.services.AgentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/agent")
@RequiredArgsConstructor
@Tag(name = "Admin Controller", description = "Admin controller")
public class AgentController {

    private final AgentService agentService;

    @Operation(
            summary = "This endpoint creates flight",
            description = "This endpoint creates flight"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully created flight"
            )
    })
    @PostMapping("/flight")
    public String createFlight(@RequestBody CreateFlightDto dto, @RequestParam Integer id) {
        return agentService.createFlight(id, dto);
    }

    @Operation(
            summary = "This endpoint updates flight",
            description = "This endpoint updates flight"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updates flight"
            )
    })
    @PostMapping("/flight/update")
    public String updateFlight(@RequestBody CreateFlightDto dto, @RequestParam Integer flightId) {
        return agentService.updateFlight(dto, flightId);
    }

}
