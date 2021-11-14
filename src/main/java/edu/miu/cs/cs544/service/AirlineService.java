package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.domain.Airline;

import java.util.List;

public interface AirlineService {

    public List<Airline> getAllAilrines();

    public Airline addAirline(Airline airline);

    public Airline findById(Long airlineId);

    public Airline update(Airline airline);

    public  void deleteAirline(Long airlineId);
}
