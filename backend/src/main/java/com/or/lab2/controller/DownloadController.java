package com.or.lab2.controller;

import com.or.lab2.service.DownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
@RequiredArgsConstructor
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
