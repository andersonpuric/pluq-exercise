package com.pluq.pluqexercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uid;
    @JsonProperty("evse_id")
    private String evseId;
    private String status;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdate;
    private List<String> capabilities;
    @JsonProperty("physical_reference")
    private String physicalReference;
    @ElementCollection
    private List<Connector> connectors;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
}
