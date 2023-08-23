package com.pluq.pluqexercise.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pluq.pluqexercise.model.MeterValue;
import com.pluq.pluqexercise.repository.MeterValueRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
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
        /*
            In this part, I mapped the contents of the json file just to save all at once in the database.
            I made this way to gain some time.
            In a real application, I wouldn't do this, I would search a better way
         */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<List<MeterValue>> typeReference = new TypeReference<>() { };
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/meterValues.json")) {
            List<MeterValue> meterValues = objectMapper.readValue(inputStream, typeReference);
            return repository.saveAll(meterValues);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
