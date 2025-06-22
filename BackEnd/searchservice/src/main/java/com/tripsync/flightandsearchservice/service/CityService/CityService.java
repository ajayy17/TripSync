package com.tripsync.flightandsearchservice.service.CityService;

import com.tripsync.flightandsearchservice.payload.CityDTO;

import java.util.List;

public interface CityService {

void addCity(CityDTO cityDTO);

List<CityDTO> getAllCities();

CityDTO updateCity(CityDTO cityDTO, String cityId);

    CityDTO deleteCity( String cityId);

    CityDTO getCityById(String cityId);

    CityDTO getCityByName(String cityName);
}
