package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Flight;
import edu.miu.cs.cs544.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository repository;

    @Override
    public List<Flight> findAllFlights() {
        return repository.findAll();
    }

    @Override
    public Flight addFlight(Flight flight) {
        return repository.save(flight);
    }

    @Override
    public Flight findById(Long flightId) {
        return repository.findById(flightId).get();
    }

    @Override
    public Flight update(Flight flight) {
        Flight entity = findById(flight.getId());
        entity.setNumber(flight.getNumber());
        entity.setCapacity(flight.getCapacity());
        entity.setDepartureTime(flight.getDepartureTime());
        entity.setArrivalTime(flight.getArrivalTime());
        entity.setDepartureAirport(flight.getDepartureAirport());
        entity.setArrivalAirport(flight.getArrivalAirport());
        entity.setAirline(flight.getAirline());
        return repository.save(entity);
    }

    @Override
    public void cancelFlight(Long flightId) {
        repository.deleteById(flightId);
    }
}
