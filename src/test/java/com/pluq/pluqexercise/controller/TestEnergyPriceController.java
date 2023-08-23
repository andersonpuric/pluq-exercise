package com.pluq.pluqexercise.controller;

import com.pluq.pluqexercise.model.EnergyPrice;
import com.pluq.pluqexercise.service.EnergyPriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EnergyPriceController.class)
public class TestEnergyPriceController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnergyPriceService service;

    @Test
    public void saveAllData() throws Exception {
        List<EnergyPrice> prices = Arrays.asList(
                new EnergyPrice("2023-07-01-0", "NL", "2,264.2", "4,775.9", "101.56", "€", "MWh", "2023-07-01","0"),
                new EnergyPrice("2023-07-01-1", "NL", "2,264.3", "5,778.9", "102.57", "€", "MWh", "2023-07-03","1")
        );

        given(service.saveAll()).willReturn(prices);

        mockMvc.perform(MockMvcRequestBuilders
                    .post("/save-all")
                    .content(String.valueOf(prices))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        ;
    }
}
