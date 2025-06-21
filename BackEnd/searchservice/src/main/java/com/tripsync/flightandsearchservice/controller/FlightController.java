package com.tripsync.flightandsearchservice.controller;

import com.tripsync.flightandsearchservice.payload.FlightDTO;
import com.tripsync.flightandsearchservice.service.FlightService.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tripSync/api/")
public class FlightController {
    
    @Autowired
    FlightService flightService;

    @PostMapping("flight/addFlight")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO) {
        flightService.createFlight(flightDTO);
        return new ResponseEntity<>(flightDTO, HttpStatus.CREATED);
    }
    

    @GetMapping("flight/getFlightByName/{PNR}")
    public ResponseEntity<FlightDTO> getFlightByName(@PathVariable String PNR) {
        FlightDTO flightDTO = flightService.findFlightByAirlinePNR(PNR);
        return new ResponseEntity<>(flightDTO, HttpStatus.FOUND);
    }

    @DeleteMapping("flight/deleteFlight/{PNR}")
    public ResponseEntity<FlightDTO> deleteFlight(@PathVariable String PNR) {
        FlightDTO flightDTO = flightService.deleteFlight(PNR);
        return new ResponseEntity<>(flightDTO, HttpStatus.OK);
    }
}
