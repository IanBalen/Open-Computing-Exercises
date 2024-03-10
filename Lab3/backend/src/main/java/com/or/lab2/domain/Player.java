package com.or.lab2.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "igraci")
public class Player {

    @Id
    @Column(name = "igracid")
    @GeneratedValue
    private Integer id;
    @Column(name = "ime")
    private String firstName;
    @Column(name = "prezime")
    private String lastName;
    @Column(name = "pozicija")
    private String position;
    @Column(name = "datumrodjenja")
    private LocalDate dateOfBirth;
    @Column(name = "visina")
    private Integer height;
    @Column(name = "tezina")
    private Integer weight;
    @Column(name = "brojdresa")
    private Integer jerseyNumber;
    @Column(name = "poenipoutakmici")
    private Double pointsPerGame;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    @JoinColumn(name = "timid", referencedColumnName = "timid")
    private Team team;


}
