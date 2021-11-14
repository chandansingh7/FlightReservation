package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Airport;
import edu.miu.cs.cs544.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportRepository repository;

    @Override
    public List<Airport> findAllAirports() {
        return repository.findAll();
    }

    @Override
    public Airport findById(Long airporId) {

        return repository.findById(airporId).get();
    }

    @Override
    public Airport addAirport(Airport airport) {
       return repository.save(airport);
    }

    @Override
    public Airport update(Airport airport) {
        Airport entity = new Airport();
        entity.setCode(airport.getCode());
        entity.setName(airport.getName());
        entity.setAddress(airport.getAddress());
        return repository.save(entity);
    }

    @Override
    public void deleteAirport(Long airportId) {
        repository.deleteById(airportId);
    }
}
