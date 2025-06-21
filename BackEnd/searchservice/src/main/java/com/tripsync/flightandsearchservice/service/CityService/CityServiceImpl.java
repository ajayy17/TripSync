package com.tripsync.flightandsearchservice.service.CityService;

import com.tripsync.flightandsearchservice.model.City;
import com.tripsync.flightandsearchservice.payload.CityDTO;
import com.tripsync.flightandsearchservice.repository.CityRepository;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CityRepository cityRepository;

    @Override
    public void addCity(CityDTO cityDTO) {
        City city = modelMapper.map(cityDTO, City.class);
        cityRepository.save(city);
    }

    @Override
    public List<CityDTO> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(city -> modelMapper.map(city, CityDTO.class))
                .toList();
    }

    @Override
    public CityDTO updateCity(CityDTO cityDTO, String cityId) {
        City returnedCity = cityRepository.findByCityId(cityId);

        if (returnedCity.getCityId().equals(cityId)) {
            returnedCity.setCityId(cityDTO.getCityId());
            returnedCity.setCityName(cityDTO.getCityName());
            cityRepository.save(returnedCity);
        }
        return modelMapper.map(returnedCity, CityDTO.class);
    }

    @Override
    public CityDTO deleteCity(String cityId) {
        City returnedCity = cityRepository.findByCityId(cityId);
        if (returnedCity.getCityId().equals(cityId)) {

            cityRepository.delete(returnedCity);
        }
        return modelMapper.map(returnedCity, CityDTO.class);
    }

    @Override
    public CityDTO getCityById(String cityId) {
        City returnedCity = cityRepository.findByCityId(cityId);
        return modelMapper.map(returnedCity, CityDTO.class);

    }

    @Override
    public CityDTO getCityByName(String cityName) {
        City returnedCity = cityRepository.findByCityName(cityName);
        return modelMapper.map(returnedCity, CityDTO.class);

    }
}
