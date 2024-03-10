package com.or.lab2.service;

import com.or.lab2.domain.Player;
import com.or.lab2.domain.PlayerTeamDTO;

public class Mapper {

    public static PlayerTeamDTO toPlayerTeamDTO(Player player){
        return PlayerTeamDTO.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .position(player.getPosition())
                .dateOfBirth(player.getDateOfBirth())
                .height(player.getHeight())
                .weight(player.getWeight())
                .jerseyNumber(player.getJerseyNumber())
                .pointsPerGame(player.getPointsPerGame())
                .name(player.getTeam().getName())
                .city(player.getTeam().getCity())
                .wins(player.getTeam().getWins())
                .losses(player.getTeam().getLosses())
                .build();
    }

}
