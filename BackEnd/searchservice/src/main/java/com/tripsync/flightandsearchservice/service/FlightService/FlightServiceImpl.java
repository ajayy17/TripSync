package com.tripsync.flightandsearchservice.service.FlightService;

import com.tripsync.flightandsearchservice.model.Flight;
import com.tripsync.flightandsearchservice.payload.FlightDTO;
import com.tripsync.flightandsearchservice.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FlightRepository flightRepository;

    @Override
    public FlightDTO findFlightByAirlinePNR(String airlinePNR) {
     Flight flight=flightRepository.findFlightByAirline_AirlinePNR(airlinePNR);
     return modelMapper.map(flight,FlightDTO.class);
    }

    @Override
    public void createFlight(FlightDTO flightDTO) {
        Flight flight= modelMapper.map(flightDTO,Flight.class);
       flightRepository.save(flight);

    }

    @Override
    public FlightDTO deleteFlight(String airlinePNR) {
        Flight returnedFlight = flightRepository.findFlightByAirline_AirlinePNR(airlinePNR);
        if (returnedFlight.getAirline().getAirlinePNR().equals(airlinePNR)) {

            flightRepository.delete(returnedFlight);
        }
        return modelMapper.map(returnedFlight, FlightDTO.class);
    }
}
