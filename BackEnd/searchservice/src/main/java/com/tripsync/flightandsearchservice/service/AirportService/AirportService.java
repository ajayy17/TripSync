package com.tripsync.flightandsearchservice.service.AirportService;

import com.tripsync.flightandsearchservice.payload.AirportDTO;
import com.tripsync.flightandsearchservice.payload.CityDTO;

import java.util.List;

public interface AirportService {

    void addAirport(AirportDTO airportDTO);

    List<AirportDTO> getAllAirports();

    AirportDTO updateAirport(AirportDTO airportDTO, String airportId);

    AirportDTO deleteAirport( String airportId);

    AirportDTO getAirportById(String airportId);

    AirportDTO getAirportByName(String airportName);

    List<AirportDTO> getAirportByCityId(String cityId);

}
