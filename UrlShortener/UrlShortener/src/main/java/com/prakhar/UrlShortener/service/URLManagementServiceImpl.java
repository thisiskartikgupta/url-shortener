package com.prakhar.UrlShortener.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class URLManagementServiceImpl implements URLManagementService {

    private static final Map<String, String> shortenedURLMap = new HashMap<>();
    private static final Map<String, String> originalURLMap = new HashMap<>();

    @Override
    public String shortenURL(String originalURL) {
        if (ObjectUtils.isEmpty(originalURL)) throw new RuntimeException("Invalid URL");

        if (originalURLMap.containsKey(originalURL)) return originalURLMap.get(originalURL);

        String uid = UUID.randomUUID().toString();
        originalURLMap.put(originalURL, uid);
        shortenedURLMap.put(uid, originalURL);

        return uid;
    }

    @Override
    public String getOriginalURL(String shortURL) {
        if (ObjectUtils.isEmpty(shortURL)) throw new RuntimeException("Invalid URL");

        return shortenedURLMap.get(shortURL);
    }

    @Override
    public Map<String, String> getAllUrls() {
        return shortenedURLMap;
    }
}
