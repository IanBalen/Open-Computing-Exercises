package com.or.lab2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PlayerTeamDTO {

    @JsonProperty("ime")
    private String firstName;
    @JsonProperty("prezime")
    private String lastName;
    @JsonProperty("pozicija")
    private String position;
    @JsonProperty("datumrodjenja")
    private LocalDate dateOfBirth;
    @JsonProperty("visina")
    private Integer height;
    @JsonProperty("tezina")
    private Integer weight;
    @JsonProperty("brojdresa")
    private Integer jerseyNumber;
    @JsonProperty("poenipoutakmici")
    private Double pointsPerGame;
    @JsonProperty("nazivtima")
    private String name;
    @JsonProperty("grad")
    private String city;
    @JsonProperty("pobjede")
    private Integer wins;
    @JsonProperty("porazi")
    private Integer losses;

}
