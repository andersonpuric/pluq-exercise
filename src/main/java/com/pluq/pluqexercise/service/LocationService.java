package com.pluq.pluqexercise.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pluq.pluqexercise.model.EnergyPrice;
import com.pluq.pluqexercise.model.Location;
import com.pluq.pluqexercise.repository.LocationRepository;
import com.pluq.pluqexercise.utils.JsonFileParser;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository repository;

    public Iterable<Location> list() {
        return repository.findAll();
    }

    public Location findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Location save(Location location) {
        return repository.save(location);
    }

    public Iterable<Location> saveAll() {
        List<Location> locations = JsonFileParser.retrieveJsonData("/locations.json");
        return repository.saveAll(locations);
    }
}
