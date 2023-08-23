package com.pluq.pluqexercise.utils;

import com.pluq.pluqexercise.model.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class TestJsonFileParser {

    @Test
    public void testParserReturnsListOfCorrectObjects() {
        List<Location> locations = JsonFileParser.retrieveJsonData("/locations.json");
        assert locations.get(0) != null;
    }
}
