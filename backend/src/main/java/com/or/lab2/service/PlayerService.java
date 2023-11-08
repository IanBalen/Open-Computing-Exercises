package com.or.lab2.service;

import com.or.lab2.domain.Player;
import com.or.lab2.domain.PlayerTeamDTO;
import com.or.lab2.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.isNumeric;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;


    public List<PlayerTeamDTO> getAllPlayers(String searchText, String attribute) {

        searchText = searchText != null ? searchText.trim() : null;
        List<Player> players;

        if((attribute == null || attribute.isEmpty() || attribute.isBlank()) &&
           (searchText == null || searchText.isEmpty() || searchText.isBlank())){
            players = playerRepository.findAll();
        } else if(isNumeric(searchText) || isDouble(searchText)){
            if(attribute != null && !attribute.isBlank() && !attribute.isEmpty()){
                players =  switch (attribute) {
                    case "visina" -> playerRepository.findAllByHeight(Integer.parseInt(searchText));
                    case "tezina" -> playerRepository.findAllByWeight(Integer.parseInt(searchText));
                    case "brojdresa" -> playerRepository.findAllByJerseyNumber(Integer.parseInt(searchText));
                    case "poenipoutakmici" -> playerRepository.findAllByPointsPerGame(Double.parseDouble(searchText));
                    case "pobjede" -> playerRepository.findAllByWins(Integer.parseInt(searchText));
                    case "porazi" -> playerRepository.findAllByLosses(Integer.parseInt(searchText));
                    default -> throw new IllegalArgumentException("Invalid attribute");
                };
            } else {
                players = playerRepository.findByAllNumber(Integer.parseInt(searchText));
            }
        } else if(isAlpha(searchText)) {
            if (attribute != null && !attribute.isBlank() && !attribute.isEmpty()) {
                players = switch (attribute) {
                    case "ime" -> playerRepository.findAllByFirstName(searchText);
                    case "prezime" -> playerRepository.findAllByLastName(searchText);
                    case "pozicija" -> playerRepository.findAllByPosition(searchText);
                    case "grad" -> playerRepository.findAllByCity(searchText);
                    case "nazivtima" -> playerRepository.findAllByTeamName(searchText);
                    default -> throw new IllegalArgumentException("Invalid attribute");
                };
            } else {
                players = playerRepository.findAllByAlpha(searchText);
            }
        } else if(isDate(searchText)) {
            LocalDate localDate = LocalDate.parse(searchText, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            players = playerRepository.findAllByDateOfBirth(localDate);
        } else{
            throw new IllegalArgumentException("Invalid search text");
        }

        List<PlayerTeamDTO> playerTeamDTOS = new ArrayList<>();
        for(Player player : players){
            playerTeamDTOS.add(Mapper.toPlayerTeamDTO(player));
        }

        return playerTeamDTOS;

    }

    private boolean isDouble(String searchText) {
        try{
            Double.parseDouble(searchText);
            return true;
        } catch (Exception e){
            return false;
        }
    }


    private boolean isDate(String searchText){
        try{
            LocalDate.parse(searchText, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
