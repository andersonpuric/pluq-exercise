package com.pluq.pluqexercise.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pluq.pluqexercise.model.EnergyPrice;
import com.pluq.pluqexercise.repository.EnergyPriceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class EnergyPriceService {

    private final EnergyPriceRepository energyPriceRepository;

    public Iterable<EnergyPrice> list() {
        return energyPriceRepository.findAll();
    }

    public EnergyPrice findById(String id) {
        return energyPriceRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public EnergyPrice save(EnergyPrice energyPrice) {
        return energyPriceRepository.save(energyPrice);
    }

    public Iterable<EnergyPrice> saveAll() {
        /*
            In this part, I mapped the contents of the json file just to save all at once in the database.
            I made this way to gain some time.
            In a real application, I wouldn't do this
         */
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<EnergyPrice>> typeReference = new TypeReference<>() {
        };
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/energyPrices.json")) {
            List<EnergyPrice> energyPrices = objectMapper.readValue(inputStream, typeReference);
            return energyPriceRepository.saveAll(energyPrices);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
