package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.domain.Airport;
import edu.miu.cs.cs544.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    @Autowired
    AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirlines(){
        return airportService.findAllAirports();
    }

    @PostMapping
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport){
        return ResponseEntity.ok(airportService.addAirport(airport));
    }

    @GetMapping("/{airportId}")
    public Airport getAirline(@PathVariable("airportId") Long airportId){
        return  airportService.findById(airportId);
    }

    @PutMapping("/{airportId}")
    public ResponseEntity<?> update(@PathVariable("airportId") Long airportId, @RequestBody Airport airport) {
        if (airportId.equals(airport.getId())) {
            return ResponseEntity.ok(airportService.update(airport));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long flightId){
        airportService.deleteAirport(flightId);
    }
}
