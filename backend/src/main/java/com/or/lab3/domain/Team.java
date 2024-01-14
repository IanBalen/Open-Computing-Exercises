package com.or.lab3.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "timovi")
public class Team {

    @Id
    @Column(name = "timid")
    private Integer id;
    @Column(name = "nazivtima")
    private String name;
    @Column(name = "grad")
    private String city;
    @Column(name = "pobjede")
    private Integer wins;
    @Column(name = "porazi")
    private Integer losses;
    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<Player> players;


}
