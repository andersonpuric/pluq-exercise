package com.pluq.pluqexercise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pluq.pluqexercise.model.EnergyPrice;
import com.pluq.pluqexercise.service.EnergyPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EnergyPriceController.class)
public class TestEnergyPriceController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnergyPriceService service;

    @Test
    public void testSaveEnergyData() throws Exception {
        ObjectMapper objm = new ObjectMapper();
        objm.registerModule(new JavaTimeModule());
        var price = new EnergyPrice("2023-07-01-0", "NL", "2,264.2", "4,775.9", "101.56", "€", "MWh", LocalDate.parse("2023-07-01"),"0");

        mockMvc.perform(MockMvcRequestBuilders
                    .post("/energy-prices/save")
                    .content(objm.writeValueAsString(price))
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
