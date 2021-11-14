package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.domain.Airline;

import edu.miu.cs.cs544.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    AirlineRepository repository;

    @Override
    public List<Airline> getAllAilrines() {
        return repository.findAll();
    }

    @Override
    public Airline addAirline(Airline airline) {
        return repository.save(airline);
    }

    @Override
    public Airline findById(Long airlineId) {
        return repository.findById(airlineId).get();
    }

    @Override
    public Airline update(Airline airline) {
        Airline entity = new Airline();
        entity.setName(airline.getName());
        entity.setHistory(airline.getHistory());
        entity.setFlights(airline.getFlights());
        return repository.save(entity);
    }

    @Override
    public void deleteAirline(Long airlineId) {
        repository.deleteById(airlineId);
    }
}
