package com.prakhar.UrlShortener.controller;

import com.prakhar.UrlShortener.service.URLManagementService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    @Autowired
    private URLManagementService urlService;

    @GetMapping("/hello")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/shorten")
    public ResponseEntity<String> getShortenedURL(@RequestParam("url") String url) {
        String key = urlService.shortenURL(url);
        return new ResponseEntity<>(key, HttpStatus.OK);
    }


    @GetMapping("/original")
    public void getOriginalURL(@RequestParam("url") String url, HttpServletResponse response) throws IOException {
        String originalURL = urlService.getOriginalURL(url);
        response.sendRedirect(originalURL);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllURL() {
        return new ResponseEntity<>(urlService.getAllUrls(), HttpStatus.OK);
    }
}
