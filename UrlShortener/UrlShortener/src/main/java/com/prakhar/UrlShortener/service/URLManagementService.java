package com.prakhar.UrlShortener.service;

import java.util.Map;

public interface URLManagementService {

    String shortenURL(String originalURL);

    String getOriginalURL(String shortURL);

    Map<String, String> getAllUrls();
}
