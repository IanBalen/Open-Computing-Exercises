package com.or.lab2.controller;

import com.or.lab2.domain.PlayerTeamDTO;
import com.or.lab2.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<PlayerTeamDTO> getPlayers(@RequestParam(value = "searchText", required = false) String searchText,
                                          @RequestParam(value = "attribute", required = false) String attribute) {
        return playerService.getAllPlayers(searchText, attribute);
    }


}
