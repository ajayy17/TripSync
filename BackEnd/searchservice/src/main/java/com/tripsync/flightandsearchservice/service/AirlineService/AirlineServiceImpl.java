package com.tripsync.flightandsearchservice.service.AirlineService;

import com.tripsync.flightandsearchservice.model.Airline;
import com.tripsync.flightandsearchservice.model.Airport;
import com.tripsync.flightandsearchservice.payload.AirlineDTO;
import com.tripsync.flightandsearchservice.payload.AirportDTO;
import com.tripsync.flightandsearchservice.repository.AirlineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public void createAirline(AirlineDTO airlineDTO) {
        Airline airline = modelMapper.map(airlineDTO, Airline.class);
        airlineRepository.save(airline);
    }

    @Override
    public AirlineDTO updateAirline(AirlineDTO airlineDTO, String airlinePNR) {
        Airline returedAirline = airlineRepository.findByAirlinePNR(airlinePNR);

        if (returedAirline.getAirlinePNR().equals(airlinePNR)) {
            returedAirline.setAirlinePNR(airlineDTO.getAirlinePNR());
            if (airlineDTO.getAirlineName() != null) {
                returedAirline.setAirlineName(airlineDTO.getAirlineName());
            }
            if ((airlineDTO.getCapacity()) != null) {
                returedAirline.setCapacity(airlineDTO.getCapacity());
            }
            if ((airlineDTO.getFromCity()) != null) {
                returedAirline.setFromCity(airlineDTO.getFromCity());
            }
            if ((airlineDTO.getToCity()) != null) {
                returedAirline.setToCity(airlineDTO.getToCity());
            }

            if ((airlineDTO.getAvailableSeats()) != null) {
                returedAirline.setAvailableSeats(airlineDTO.getAvailableSeats());
            }
            if ((airlineDTO.getBookedSeats()) != null) {
                returedAirline.setBookedSeats(airlineDTO.getBookedSeats());
            }

            airlineRepository.save(returedAirline);
        }
        return modelMapper.map(returedAirline, AirlineDTO.class);
    }

    @Override
    public AirlineDTO deleteAirline(String airline) {
        Airline returnedAirline = airlineRepository.findByAirlinePNR(airline);

        if (returnedAirline.getAirlinePNR().equals(airline)) {

            airlineRepository.delete(returnedAirline);
        }
        return modelMapper.map(returnedAirline, AirlineDTO.class);
    }

    @Override
    public AirlineDTO findByAirlinePNR(String airlinePNR) {
        Airline returnedAirline = airlineRepository.findByAirlinePNR(airlinePNR);
        return modelMapper.map(returnedAirline, AirlineDTO.class);
    }

    @Override
    public List<AirlineDTO> getAllAirlines() {
        List<Airline> airlines = airlineRepository.findAll();
        return airlines.stream()
                .map(airline -> modelMapper.map(airline, AirlineDTO.class))
                .toList();
    }

    @Override
    public AirlineDTO findByAirlineName(String airlineName) {
        Airline returnedAirline = airlineRepository.findByAirlineName(airlineName);
        return modelMapper.map(returnedAirline, AirlineDTO.class);
    }

    @Override
    public List<AirlineDTO> findByDepartureAndArrivalCity(String fromCity, String toCity) {
        List<Airline> airlines = airlineRepository.findByFromAndToCity(fromCity, toCity);

        return airlines.stream()
                .map(airline -> modelMapper.map(airline, AirlineDTO.class))
                .toList();
    }

    @Override
    public Integer totalCapacity(String airlinePNR) {
        return  airlineRepository.findCapacityByAirlinePNR(airlinePNR);


    }

    @Override
    public Integer totalAvailableSeats(String airlinePNR) {
        return airlineRepository.findAvailableSeatsByAirlinePNR(airlinePNR);

    }

    @Override
    public Integer totalBookedSeats(String airlinePNR) {
     return airlineRepository.findBookedSeatsByAirlinePNR(airlinePNR);

    }
}
