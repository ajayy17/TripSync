package com.tripsync.flightandsearchservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "flight",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "PNR"),
        })

public class Flight {
    @NotBlank
    @Column(name="flightPNR")
    @Id
    private int FlightPNR;

    @NotBlank
    @Column(name="departureId")
    private int departureId;                    //id of airport

    @NotBlank
    @Column(name="ArrivalId")
    private String arrivalId;            //id of airport

    @NotBlank
    @Column(name="TotalPrice")
    private int totalPrice;

    @NotBlank
    @Column(name="TotalSeats")
    private int totalSeats;

    @ManyToOne
    @JoinColumn(name = "AirlinePNR") // This column will exist in the Airline table
    private Airline airline;
}
