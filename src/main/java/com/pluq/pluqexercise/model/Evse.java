package com.pluq.pluqexercise.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Evse {

    private String uid;
    private String evseId;
    private String status;
    private LocalDateTime lastUpdate;
    private List<String> capabilities;
    private String physicalReference;
    @Embedded
    private Connector connector;
}
