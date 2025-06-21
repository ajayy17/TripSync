package com.tripsync.flightandsearchservice.repository;


import com.tripsync.flightandsearchservice.model.Airport;
import com.tripsync.flightandsearchservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport,String> {

    Airport findByAirportId(String airportId);

    Airport findByAirportName(String airportName);

    List<Airport> findByCity_cityId(String cityId);

}
