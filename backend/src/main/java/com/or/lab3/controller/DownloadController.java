package com.or.lab3.controller;

import com.or.lab3.service.DownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/download")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DownloadController {

    private final DownloadService downloadService;

    @GetMapping("/json")
    public ResponseEntity<byte[]> downloadJsonFile(@RequestParam(value = "searchText", required = false) String searchText,
                                                   @RequestParam(value = "attribute", required = false) String attribute) {

        byte[] jsonData = downloadService.getAllPlayersJSON(searchText, attribute);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentDispositionFormData("attachment", "data.json");

        return new ResponseEntity<>(jsonData, headers, HttpStatus.OK);
    }

    @GetMapping("/csv")
    public ResponseEntity<byte[]> downloadCsvFile(@RequestParam(value = "searchText", required = false) String searchText,
                                                  @RequestParam(value = "attribute", required = false) String attribute) {
        byte[] csvData = downloadService.getAllPlayersCSV(searchText, attribute);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("attachment", "data.csv");

        return new ResponseEntity<>(csvData, headers, HttpStatus.OK);
    }

}
