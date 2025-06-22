package com.tripsync.flightandsearchservice.controller;


import com.tripsync.flightandsearchservice.payload.AirlineDTO;
import com.tripsync.flightandsearchservice.service.AirlineService.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tripSync/api/")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @PostMapping("airline/addAirline")
    public ResponseEntity<AirlineDTO> addAirline(@RequestBody AirlineDTO airlineDTO) {
        airlineService.createAirline(airlineDTO);
        return new ResponseEntity<>(airlineDTO, HttpStatus.CREATED);
    }

    @GetMapping("airline/getAllAirlines")
    public ResponseEntity<List<AirlineDTO>> getAllAirlines() {
        List<AirlineDTO> airlines = airlineService.getAllAirlines();
        return new ResponseEntity<>(airlines, HttpStatus.FOUND);
    }

    @GetMapping("airline/getAirlineByName/{name}")
    public ResponseEntity<AirlineDTO> getAirlineByName(@PathVariable String name) {
        AirlineDTO airlineDTO = airlineService.findByAirlineName(name);
        return new ResponseEntity<>(airlineDTO, HttpStatus.FOUND);
    }

    @DeleteMapping("airline/deleteAirline/{PNR}")
    public ResponseEntity<AirlineDTO> deleteAirline(@PathVariable String PNR) {
        AirlineDTO airlineDTO = airlineService.deleteAirline(PNR);
        return new ResponseEntity<>(airlineDTO, HttpStatus.OK);
    }

    @PutMapping("airline/updateAirline/{PNR}")
    public ResponseEntity<AirlineDTO> updateAirline(@PathVariable String PNR, @RequestBody AirlineDTO airline) {
        AirlineDTO updateAirline = airlineService.updateAirline(airline, PNR);
        return new ResponseEntity<>(updateAirline, HttpStatus.OK);
    }

    @GetMapping("airline/getAirlinesCapacity/{PNR}")
    public ResponseEntity<Integer> getAirlineCapacity(@PathVariable String PNR) {
        Integer airlineCapacity = airlineService.totalCapacity(PNR);
        return new ResponseEntity<>(airlineCapacity, HttpStatus.FOUND);
    }

    @GetMapping("airline/getAirlinesBookedSeats/{PNR}")
    public ResponseEntity<Integer> getAirlineBookedSeats(@PathVariable String PNR) {
        Integer totalBookedSeats = airlineService.totalBookedSeats(PNR);
        return new ResponseEntity<>(totalBookedSeats, HttpStatus.FOUND);
    }

    @GetMapping("airline/getAirlinesAvailableSeats/{PNR}")
    public ResponseEntity<Integer> getAirlineAvailableSeats(@PathVariable String PNR) {
        Integer totalAvailableSeats = airlineService.totalAvailableSeats(PNR);
        return new ResponseEntity<>(totalAvailableSeats, HttpStatus.FOUND);
    }

    @GetMapping("airline/findByDepartureAndArrivalCity/{DepartureId}/{ArrivalId}")
    public ResponseEntity<List<AirlineDTO>> findByDepartureAndArrivalCity(@PathVariable String DepartureId, @PathVariable String ArrivalId) {
        List<AirlineDTO> airlines = airlineService.findByDepartureAndArrivalCity(DepartureId, ArrivalId);
        return new ResponseEntity<>(airlines, HttpStatus.FOUND);
    }

}
