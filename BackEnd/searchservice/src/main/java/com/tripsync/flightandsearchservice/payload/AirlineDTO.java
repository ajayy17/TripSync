package com.tripsync.flightandsearchservice.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirlineDTO {

    private String airlinePNR;

    private String airlineName;

    private String fromCity;

    private String toCity;

    private Integer capacity;

    private Integer availableSeats;

    private Integer bookedSeats;
}
