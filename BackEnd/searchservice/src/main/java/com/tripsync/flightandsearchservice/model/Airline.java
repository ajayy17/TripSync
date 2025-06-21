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
                @UniqueConstraint(columnNames = "airlinePNR"),
        })

public class Airline {
    @NotBlank
    @Column(name="airlinePNR")
    @Id
    private String airlinePNR;

    @NotBlank
    @Column(name="airlineName")
    private String airlineName;

    @NotBlank
    @Column(name="fromCity")
    private String fromCity;


    @NotBlank
    @Column(name="toCity")
    private String toCity;

    @NotBlank
    @Column(name="capacity")
    private Integer capacity;

    @NotBlank
    @Column(name="availableSeats")
    private Integer availableSeats;

    @NotBlank
    @Column(name="bookedSeats")
    private Integer bookedSeats;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> flights = new ArrayList<>();

}
