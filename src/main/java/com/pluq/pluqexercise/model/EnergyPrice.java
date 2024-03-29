package com.pluq.pluqexercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EnergyPrice {

    @Id
    private String id;
    private String country;
    private String buyVolume;
    private String sellVolume;
    private String price;
    private String currency;
    private String unit;
    private LocalDate date;
    private String timeslot;
}
