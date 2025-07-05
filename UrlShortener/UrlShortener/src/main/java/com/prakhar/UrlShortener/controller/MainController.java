package com.prakhar.UrlShortener.controller;

import com.prakhar.UrlShortener.service.URLManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private URLManagementService urlService;

    @GetMapping("/hello")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/shorten/get")
    public ResponseEntity<String> getShortenedURL(@RequestParam("url") String url) {
        String key = urlService.shortenURL(url);
        return new ResponseEntity<>(key, HttpStatus.OK);
    }


    @GetMapping("/original/get")
    public ResponseEntity<String> getOriginalURL(@RequestParam("url") String url) {
        String originalURL = urlService.getOriginalURL(url);

        return new ResponseEntity<>(originalURL, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllURL() {
        return new ResponseEntity<>(urlService.getAllUrls(), HttpStatus.OK);
    }
}
