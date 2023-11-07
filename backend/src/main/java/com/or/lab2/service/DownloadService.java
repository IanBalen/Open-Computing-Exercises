package com.or.lab2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opencsv.CSVWriter;
import com.or.lab2.domain.Player;
import com.or.lab2.domain.PlayerTeamDTO;
import com.or.lab2.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isAlphaSpace;
import static org.apache.commons.lang3.StringUtils.isNumeric;

@Service
@RequiredArgsConstructor
public class DownloadService {

    private final PlayerRepository playerRepository;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


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

        if (attribute == null && searchText == null) {
            players = playerRepository.findAll();
        } else if (isNumeric(searchText) || isDouble(searchText)) {
            if (attribute != null) {
                players = switch (attribute) {
                    case "visina" -> playerRepository.findAllByHeight(Integer.parseInt(searchText));
                    case "tezina" -> playerRepository.findAllByWeight(Integer.parseInt(searchText));
                    case "brojdresa" -> playerRepository.findAllByJerseyNumber(Integer.parseInt(searchText));
                    case "poenipoutakmici" -> playerRepository.findAllByPointsPerGame(Double.parseDouble(searchText));
                    default -> throw new IllegalArgumentException("Invalid attribute");
                };
            } else {
                players = playerRepository.findByAllNumber(searchText);
            }
        } else if (isAlphaSpace(searchText)) {
            if (attribute != null) {
                players = switch (attribute) {
                    case "ime" -> playerRepository.findAllByFirstName(searchText);
                    case "prezime" -> playerRepository.findAllByLastName(searchText);
                    case "pozicija" -> playerRepository.findAllByPosition(searchText);
                    default -> throw new IllegalArgumentException("Invalid attribute");
                };
            } else {
                players = playerRepository.findAllByAlpha(searchText);
            }
        } else if (isDate(searchText)) {
            LocalDate localDate = LocalDate.parse(searchText, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            players = playerRepository.findAllByDateOfBirth(date);
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
