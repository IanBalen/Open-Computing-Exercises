package com.or.lab3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opencsv.CSVWriter;
import com.or.lab3.domain.Player;
import com.or.lab3.domain.PlayerTeamDTO;
import com.or.lab3.repository.PlayerRepository;
import com.or.lab3.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;

@Service
@RequiredArgsConstructor
public class DownloadService {

    private final PlayerRepository playerRepository;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .enable(SerializationFeature.INDENT_OUTPUT);


    @SneakyThrows
    public byte[] getAllPlayersJSON(String searchText, String attribute) {

        List<PlayerTeamDTO> players = getPlayers(searchText, attribute);

        return objectMapper.writeValueAsBytes(players);
    }


    @SneakyThrows
    public byte[] getAllPlayersCSV(String searchText, String attribute) {

        List<PlayerTeamDTO> players = getPlayers(searchText, attribute);

        StringWriter stringWriter = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(stringWriter);

        String[] header = {"ime", "prezime", "pozicija", "datumrodjenja", "visina", "tezina", "brojdresa", "poenipoutakmici", "nazivtima", "grad", "pobjede", "porazi"};
        csvWriter.writeNext(header);

        for (PlayerTeamDTO player : players) {
            String[] row = {
                    player.getFirstName(),
                    player.getLastName(),
                    player.getPosition(),
                    String.valueOf(player.getDateOfBirth()),
                    String.valueOf(player.getHeight()),
                    String.valueOf(player.getWeight()),
                    String.valueOf(player.getJerseyNumber()),
                    String.valueOf(player.getPointsPerGame()),
                    player.getName(),
                    player.getCity(),
                    String.valueOf(player.getWins()),
                    String.valueOf(player.getLosses())
            };
            csvWriter.writeNext(row);
        }

        return stringWriter.toString().getBytes();
    }


    private List<PlayerTeamDTO> getPlayers(String searchText, String attribute) {
        List<Player> players;
        searchText = searchText != null ? searchText.trim() : null;


        if((attribute == null || attribute.isEmpty() || attribute.isBlank()) &&
           (searchText == null || searchText.isEmpty() || searchText.isBlank())){
            players = playerRepository.findAll();
        } else if (isNumeric(searchText) || isDouble(searchText)) {
            if (attribute != null && !attribute.isBlank() && !attribute.isEmpty()) {
                players = switch (attribute) {
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
        } else if (isAlpha(searchText)) {
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
        } else if (isDate(searchText)) {
            LocalDate localDate = LocalDate.parse(searchText, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            players = playerRepository.findAllByDateOfBirth(localDate);
        } else {
            throw new IllegalArgumentException("Invalid search text");
        }

        List<PlayerTeamDTO> playerTeamDTOS = new ArrayList<>();
        for(Player player : players){
            playerTeamDTOS.add(Mapper.toPlayerTeamDTO(player));
        }

        return playerTeamDTOS;
    }


    private boolean isDouble(String searchText) {
        try {
            Double.parseDouble(searchText);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private boolean isDate(String searchText) {
        try {
            LocalDate.parse(searchText, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
