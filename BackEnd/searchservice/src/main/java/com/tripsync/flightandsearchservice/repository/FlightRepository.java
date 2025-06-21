package com.tripsync.flightandsearchservice.repository;

import com.tripsync.flightandsearchservice.model.Airline;
import com.tripsync.flightandsearchservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

        Flight findFlightByAirline_AirlinePNR(String airlinePNR);


}
