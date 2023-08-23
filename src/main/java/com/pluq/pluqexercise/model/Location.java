package com.pluq.pluqexercise.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    @Id
    private Long id;
    private String type;
    private String address;
    private String city;
    @JsonProperty("postal_code")
    private String postalCode;
    private String country;
    private String name;
    @Embedded
    private Coordinate coordinates;
    @JsonProperty("charging_when_closed")
    private Boolean chargingWhenClosed;
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("opening_times")
    @Embedded
    private OpeningTimes openingTimes;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
    @OneToMany(mappedBy = "location")
    private List<Evse> evses;

}
