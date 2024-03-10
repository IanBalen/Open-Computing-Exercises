package com.or.lab3.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
@Builder
public class PlayerTeamDTO {

    private final Map<String, String> json_ld= Map.of(
            "@context", "https://schema.org",
            "@type", "Person",
            "givenName", "firstName",
            "familyName", "lastName"
            );
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
