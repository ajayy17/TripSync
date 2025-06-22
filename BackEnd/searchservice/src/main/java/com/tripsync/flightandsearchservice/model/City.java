package com.tripsync.flightandsearchservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(exclude = "airports")
@NoArgsConstructor
@Table(name = "city",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cityId"),

        })


public class City {

@NotBlank
@Column(name="cityId")
@Id
    private String cityId;

    @NotBlank
    @Column(name="cityName")
    private String cityName;

    // One user has many posts
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Airport> airports = new ArrayList<>();


}
