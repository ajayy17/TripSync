package com.tripsync.flightandsearchservice.service.AirportService;

import com.tripsync.flightandsearchservice.model.Airport;
import com.tripsync.flightandsearchservice.model.City;
import com.tripsync.flightandsearchservice.payload.AirportDTO;
import com.tripsync.flightandsearchservice.payload.CityDTO;
import com.tripsync.flightandsearchservice.repository.AirportRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AirportRepository airportRepository;

    @Override
    public void addAirport(AirportDTO airportDTO) {
        Airport airport = modelMapper.map(airportDTO, Airport.class);
        airportRepository.save(airport);
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream()
                .map(airport -> modelMapper.map(airport, AirportDTO.class))
                .toList();
    }

    @Override
    public AirportDTO updateAirport(AirportDTO airportDTO, String airportId) {
        Airport returnedAirport = airportRepository.findByAirportId(airportId);

        if (returnedAirport.getAirportId().equals(airportId)) {
            returnedAirport.setAirportId(airportDTO.getAirportId());
            returnedAirport.setAirportName(airportDTO.getAirportName());
            airportRepository.save(returnedAirport);
        }
        return modelMapper.map(returnedAirport, AirportDTO.class);
    }

    @Override
    public AirportDTO deleteAirport(String airportId) {
        Airport returnedAirport = airportRepository.findByAirportId(airportId);

        if (returnedAirport.getAirportId().equals(airportId)) {

            airportRepository.delete(returnedAirport);
        }
        return modelMapper.map(returnedAirport, AirportDTO.class);
    }

    @Override
    public AirportDTO getAirportById(String airportId) {
        Airport returnedAirport = airportRepository.findByAirportId(airportId);
        return modelMapper.map(returnedAirport, AirportDTO.class);
    }

    @Override
    public AirportDTO getAirportByName(String airportName) {
        Airport returnedAirport = airportRepository.findByAirportName(airportName);
        return modelMapper.map(returnedAirport, AirportDTO.class);
    }

    @Override
    public List<AirportDTO> getAirportByCityId(String cityId) {
//       City city= modelMapper.map(cityId, City.class);


        List<Airport> airports = airportRepository.findByCity_cityId(cityId);
        System.out.println(airports);
        return airports.stream()
                .map(airport -> modelMapper.map(airport, AirportDTO.class))
                .toList();
    }
}
