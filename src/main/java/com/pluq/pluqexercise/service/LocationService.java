package com.pluq.pluqexercise.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pluq.pluqexercise.model.Location;
import com.pluq.pluqexercise.repository.LocationRepository;
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
        /*
            In this part, I mapped the contents of the json file just to save all at once in the database.
            I made this way to gain some time.
            In a real application, I wouldn't do this, I would search a better way
         */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<List<Location>> typeReference = new TypeReference<>() { };
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/locations.json")) {
            List<Location> locations = objectMapper.readValue(inputStream, typeReference);
            return repository.saveAll(locations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
