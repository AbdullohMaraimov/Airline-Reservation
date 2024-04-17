package com.AirlineReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AirlineReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationApplication.class, args);
	}

}
