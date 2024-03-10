package com.or.lab2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDTO {

    private Integer id;
    private String name;
    private String city;
    private Integer wins;
    private Integer losses;

}
