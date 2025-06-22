package com.tripsync.flightandsearchservice.service.AirlineService;

import com.tripsync.flightandsearchservice.payload.AirlineDTO;

import java.util.List;

public interface AirlineService {

    void createAirline(AirlineDTO airlineDTO);

    AirlineDTO deleteAirline(String airlinePNR);

    AirlineDTO updateAirline(AirlineDTO airlineDTO,String airlinePNR);

    AirlineDTO findByAirlinePNR(String airlinePNR);

    List<AirlineDTO> getAllAirlines();

    AirlineDTO findByAirlineName(String airlineName);

    List<AirlineDTO> findByDepartureAndArrivalCity(String fromCity, String toCity);

    Integer totalCapacity(String airlinePNR);

    Integer totalAvailableSeats(String airlinePNR);

    Integer totalBookedSeats(String airlinePNR);
}
