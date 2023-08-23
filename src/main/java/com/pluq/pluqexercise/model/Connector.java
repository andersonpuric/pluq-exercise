package com.pluq.pluqexercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Connector {

    private Long id;
    private String standard;
    private String format;
    @JsonProperty("power_type")
    private String powerType;
    private String voltage;
    private String amperage;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("tariff_id")
    private String tafiffId;
}
