package com.tripsync.flightandsearchservice.service.FlightService;

import com.tripsync.flightandsearchservice.payload.FlightDTO;

public interface FlightService {

FlightDTO findFlightByAirlinePNR(String airlinePNR);

void createFlight(FlightDTO flightDTO);

    FlightDTO deleteFlight(String airlinePNR);

}
