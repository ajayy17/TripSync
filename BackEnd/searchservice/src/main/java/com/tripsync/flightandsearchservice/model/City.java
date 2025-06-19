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
@Table(name = "city",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cityId"),

        })


public class City {

@NotBlank
@Column(name="cityId")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CityId;

    @NotBlank
    @Column(name="cityName")
    private String CityName;

    // One user has many posts
    @OneToMany(mappedBy = "City", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Airport> airports = new ArrayList<>();


}
