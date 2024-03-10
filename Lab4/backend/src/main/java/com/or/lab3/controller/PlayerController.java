package com.or.lab3.controller;

import com.or.lab3.domain.AddPlayerDTO;
import com.or.lab3.domain.PlayerTeamDTO;
import com.or.lab3.domain.TeamDTO;
import com.or.lab3.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
@CrossOrigin("*")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerTeamDTO>> getPlayers(@RequestParam(value = "searchText", required = false) String searchText,
                                                          @RequestParam(value = "attribute", required = false) String attribute) {
        return playerService.getAllPlayers(searchText, attribute);
    }

    @GetMapping("/team")
    public ResponseEntity<List<TeamDTO>> getTeams() {
        return playerService.getTeams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerTeamDTO> getPlayer(@PathVariable("id") Integer id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public ResponseEntity<String> addPlayer(@RequestBody AddPlayerDTO request) {
        return playerService.addPlayer(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable("id") Integer id, @RequestBody AddPlayerDTO request) {
        return playerService.updatePlayer(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable("id") Integer id) {
        return playerService.deletePlayer(id);
    }


}
