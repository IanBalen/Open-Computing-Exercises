package com.or.lab2.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PlayerTeamDTO {

    private String firstName;
    private String lastName;
    private String position;
    private LocalDate dateOfBirth;
    private Integer height;
    private Integer weight;
    private Integer jerseyNumber;
    private Double pointsPerGame;
    private String name;
    private String city;
    private Integer wins;
    private Integer losses;

}
