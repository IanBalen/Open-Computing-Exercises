package com.or.lab3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDTO {

    private final Map<String, String> json_ld= Map.of(
            "@context", "https://schema.org",
            "@type", "SportsTeam",
            "givenName", "name"
    );
    private Integer id;
    private String name;
    private String city;
    private Integer wins;
    private Integer losses;

}
