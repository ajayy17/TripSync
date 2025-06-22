package com.tripsync.flightandsearchservice.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDTO
{
    private String airportId;

    private String airportName;

    private String cityId;

}
