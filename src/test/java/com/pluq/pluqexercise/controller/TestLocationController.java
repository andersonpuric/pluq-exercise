package com.pluq.pluqexercise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pluq.pluqexercise.model.Location;
import com.pluq.pluqexercise.service.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LocationController.class)
public class TestLocationController {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    LocationService service;

    @Test
    public void testValidPathAndHTTPMethod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/locations/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeserializationJson() throws Exception {
        Location location = new Location(89358448L, "UNKNOWN", "An Address 1", "City", null, null, null, null, null, null, null, null, null);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/locations/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(location)))
                .andExpect(status().isOk());
    }
}
