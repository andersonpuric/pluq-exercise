package com.pluq.pluqexercise.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pluq.pluqexercise.model.EnergyPrice;
import com.pluq.pluqexercise.repository.EnergyPriceRepository;
import com.pluq.pluqexercise.utils.JsonFileParser;
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
        List<EnergyPrice> energyPrices = JsonFileParser.retrieveJsonData("/energyPrices.json");
        return energyPriceRepository.saveAll(energyPrices);
    }
}
