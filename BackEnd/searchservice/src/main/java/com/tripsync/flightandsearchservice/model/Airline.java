package com.tripsync.flightandsearchservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "airline",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "PNR"),
        })

public class Airline {
    @NotBlank
    @Column(name="PNR")
    @Id
    private int PNR;

    @NotBlank
    @Column(name="AirlineName")
    private String airlineName;

    @NotBlank
    @Column(name="fromCity")
    private String from;


    @NotBlank
    @Column(name="toCity")
    private int to;

    @NotBlank
    @Column(name="Capacity")
    private int capacity;

    @NotBlank
    @Column(name="AvailableSeats")
    private int availableSeats;

    @NotBlank
    @Column(name="BookedSeats")
    private int bookedSeats;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> flights = new ArrayList<>();

}
