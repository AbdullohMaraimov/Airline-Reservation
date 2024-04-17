package com.AirlineReservation.repositories;

import com.AirlineReservation.models.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
}
