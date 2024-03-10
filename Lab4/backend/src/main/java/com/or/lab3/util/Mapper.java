package com.or.lab3.util;

import com.or.lab3.domain.Player;
import com.or.lab3.domain.PlayerTeamDTO;

public class Mapper {

    private Mapper() {
        throw new IllegalStateException("Utility class");
    }

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
