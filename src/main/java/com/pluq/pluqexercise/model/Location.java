package com.pluq.pluqexercise.model;

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
public class Location {

    @Id
    private Long id;
    private String type;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String name;
    @Embedded
    private Coordinate coordinates;
    private Boolean chargeWhenClosed;
    private LocalDateTime lastUpdate;
    @Embedded
    private List<Evse> evses;

}
