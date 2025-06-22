package com.tripsync.flightandsearchservice.controller;


import com.tripsync.flightandsearchservice.payload.CityDTO;
import com.tripsync.flightandsearchservice.service.CityService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tripSync/api/")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("city/addCity")
    public ResponseEntity<CityDTO> addCity(@RequestBody CityDTO cityDTO) {
        cityService.addCity(cityDTO);
        return new ResponseEntity<>(cityDTO,HttpStatus.CREATED);
    }
    @GetMapping("city/getAllCites")
    public ResponseEntity<List<CityDTO>> getAllCities(){
        List<CityDTO> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.FOUND);
    }

    @GetMapping("city/getCityByName/{name}")
    public ResponseEntity<CityDTO> getCityByName(@PathVariable String name){
        CityDTO cityDTO = cityService.getCityByName(name);
        return new ResponseEntity<>(cityDTO, HttpStatus.FOUND);
    }

    @GetMapping("city/getCityById/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable String id){
        CityDTO cityDTO = cityService.getCityById(id);
        return new ResponseEntity<>(cityDTO, HttpStatus.FOUND);
    }

    @DeleteMapping("city/deleteCity/{id}")
    public ResponseEntity<CityDTO> deleteCity(@PathVariable String id){
        CityDTO cityDTO = cityService.deleteCity(id);
        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PutMapping("city/updateCity/{id}")
    public ResponseEntity<CityDTO> updateCity(@PathVariable String id, @RequestBody CityDTO city){
        CityDTO updateCity = cityService.updateCity(city,id);
        return new ResponseEntity<>(updateCity, HttpStatus.OK);
    }


}


