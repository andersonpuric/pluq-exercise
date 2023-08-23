package com.pluq.pluqexercise.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonFileParser {

    /*
            In this part, I mapped the contents of the json file just to save all at once in the database.
            I made this way to gain some time.
            In a real application, I wouldn't do this, I would search a better way
         */
    public static <T> List<T> retrieveJsonData(String file) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<T>> typeReference = new TypeReference<>() { };
        try (InputStream inputStream = TypeReference.class.getResourceAsStream(file)) {
            return objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
