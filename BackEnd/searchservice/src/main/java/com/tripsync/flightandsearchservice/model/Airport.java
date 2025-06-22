package com.tripsync.flightandsearchservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "city")
@NoArgsConstructor
@Table(name = "airport",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "airportId"),
        })

public class Airport {

    @NotBlank
    @Column(name="airportId")
    @Id
    private String airportId;

    @NotBlank
    @Column(name="airportName")
    private String airportName;

    @ManyToOne
    @JoinColumn(name = "cityId") // This column will exist in the Airport table
    private City city;

}
