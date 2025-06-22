package com.tripsync.flightandsearchservice.payload;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private Long id;
    private String departureId;

    private String arrivalId;

    private Integer totalPrice;

    private Integer totalSeats;

    private String airlinePNR;
}
