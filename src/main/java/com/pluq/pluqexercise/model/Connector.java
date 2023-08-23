package com.pluq.pluqexercise.model;

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
    private String powerType;
    private String voltage;
    private String amperage;
    private LocalDateTime lastUpdated;
    private String tafiffId;
}
