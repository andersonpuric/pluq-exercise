package com.pluq.pluqexercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private String date;
    private String timeslot;
}
