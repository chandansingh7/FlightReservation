package edu.miu.cs.cs544.service;



import edu.miu.cs.cs544.domain.Airport;

import java.util.List;

public interface AirportService {

    List<Airport> findAllAirports();

    Airport findById(Long airporId);

    Airport addAirport(Airport airport);

    Airport update(Airport airport);

    void deleteAirport(Long flightId);


}
