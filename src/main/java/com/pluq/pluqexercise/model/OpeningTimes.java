package com.pluq.pluqexercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OpeningTimes {

    @JsonProperty("twentyfourseven")
    private Boolean twentyFourSeven;
}
