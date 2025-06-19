package com.tripsync.flightandsearchservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "airport",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "AirportId"),
        })

public class Airport {

    @NotBlank
    @Column(name="AirportId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airportId;

    @NotBlank
    @Column(name="AirportName")
    private String airportName;

    @ManyToOne
    @JoinColumn(name = "cityId") // This column will exist in the Airport table
    private City city;

}
