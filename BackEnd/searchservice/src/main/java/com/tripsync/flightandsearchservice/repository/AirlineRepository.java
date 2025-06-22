package com.tripsync.flightandsearchservice.repository;


import com.tripsync.flightandsearchservice.model.Airline;
import com.tripsync.flightandsearchservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Long> {

    Airline findByAirlinePNR(String airlinePNR);

    Airline findByFromCity(String fromCity);

    Airline findByToCity(String toCity);

    Airline findByAirlineName(String airlineName);

    @Query("SELECT a FROM Airline a WHERE a.fromCity = :fromCity AND a.toCity = :toCity")
    List<Airline> findByFromAndToCity(@Param("fromCity") String fromCity, @Param("toCity") String toCity);

    @Query("SELECT capacity FROM Airline a WHERE a.airlinePNR = :airlinePNR")
    Integer findCapacityByAirlinePNR(String airlinePNR);

    @Query("SELECT availableSeats FROM Airline a WHERE a.airlinePNR = :airlinePNR")
    Integer findAvailableSeatsByAirlinePNR(String airlinePNR);

    @Query("SELECT bookedSeats FROM Airline a WHERE a.airlinePNR = :airlinePNR")
    Integer findBookedSeatsByAirlinePNR(String airlinePNR);

}
