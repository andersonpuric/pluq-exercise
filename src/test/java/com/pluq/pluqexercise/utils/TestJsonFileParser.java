package com.pluq.pluqexercise.utils;

import com.pluq.pluqexercise.model.Location;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestJsonFileParser {

    @Test
    public void testParserReturnsListOfCorrectObjects() {
        List<Location> locations = JsonFileParser.retrieveJsonData("/locations.json");
        assert locations.get(0) != null;
    }
}
