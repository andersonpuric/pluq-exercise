package com.pluq.pluqexercise.service;

import com.pluq.pluqexercise.model.MeterValue;
import com.pluq.pluqexercise.repository.MeterValueRepository;
import com.pluq.pluqexercise.utils.JsonFileParser;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MeterValueService {

    private final MeterValueRepository repository;

    public Iterable<MeterValue> list() {
        return repository.findAll();
    }

    public MeterValue findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public MeterValue save(MeterValue meterValue) {
        return repository.save(meterValue);
    }

    public Iterable<MeterValue> saveAll() {
        List<MeterValue> meterValues = JsonFileParser.retrieveJsonData("/meterValues.json");
        return repository.saveAll(meterValues);
    }
}
