package com.tripsync.flightandsearchservice.controller;

import com.tripsync.flightandsearchservice.payload.AirportDTO;
import com.tripsync.flightandsearchservice.service.AirportService.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tripSync/api/")
public class AirportController {


    @Autowired
    AirportService airportService;

    @PostMapping("airport/addAirport")
    public ResponseEntity<AirportDTO> addAirport(@RequestBody AirportDTO airportDTO) {
        airportService.addAirport(airportDTO);
        return new ResponseEntity<>(airportDTO, HttpStatus.CREATED);
    }
    @GetMapping("airport/getAllAirports")
    public ResponseEntity<List<AirportDTO>> getAllAirports(){
        List<AirportDTO> airports = airportService.getAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.FOUND);
    }

    @GetMapping("airport/getAirportByCityId/{cityId}")
    public ResponseEntity<List<AirportDTO>> getAirportByCityId(@PathVariable String cityId){
        List<AirportDTO> airports = airportService.getAirportByCityId(cityId);
        return new ResponseEntity<>(airports, HttpStatus.FOUND);
    }

    @GetMapping("airport/getAirportByName/{name}")
    public ResponseEntity<AirportDTO> getAirportByName(@PathVariable String name){
        AirportDTO airportDTO = airportService.getAirportByName(name);
        return new ResponseEntity<>(airportDTO, HttpStatus.FOUND);
    }

    @DeleteMapping("airport/deleteAirport/{id}")
    public ResponseEntity<AirportDTO> deleteAirport(@PathVariable String id){
        AirportDTO airportDTO = airportService.deleteAirport(id);
        return new ResponseEntity<>(airportDTO, HttpStatus.OK);
    }

    @PutMapping("airport/updateAirport/{name}")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable String id, @RequestBody AirportDTO airport){
        AirportDTO updateAirport = airportService.updateAirport(airport,id);
        return new ResponseEntity<>(updateAirport, HttpStatus.OK);
    }
}
