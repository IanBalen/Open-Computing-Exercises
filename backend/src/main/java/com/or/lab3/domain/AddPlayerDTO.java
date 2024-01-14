package com.or.lab3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPlayerDTO {

    private String firstName;
    private String lastName;
    private String position;
    private LocalDate dateOfBirth;
    private Integer height;
    private Integer weight;
    private Integer jerseyNumber;
    private Double pointsPerGame;
    private String teamId;

}
