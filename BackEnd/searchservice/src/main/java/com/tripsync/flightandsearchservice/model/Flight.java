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
                @UniqueConstraint(columnNames = "id"),
        })

public class Flight {


    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="departureId")
    private String departureId;                    //id of airport

    @NotBlank
    @Column(name="arrivalId")
    private String arrivalId;            //id of airport


    @Column(name="totalPrice")
    private Integer totalPrice;


    @Column(name="totalSeats")
    private Integer totalSeats;

    @ManyToOne
    @JoinColumn(name = "airlinePNR") // This column will exist in the Airline table
    private Airline airline;
}
