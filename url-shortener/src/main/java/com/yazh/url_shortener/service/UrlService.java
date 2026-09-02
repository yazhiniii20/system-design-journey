package com.yazh.url_shortener.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.yazh.url_shortener.exception.UrlNotFoundException;
import com.yazh.url_shortener.model.Url;
import com.yazh.url_shortener.repository.UrlRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    public Url createShortUrl(String originalUrl){
            String shortCode;
            do{
                shortCode = generateShortCode();
            }while(urlRepository.existsByShortCode(shortCode));

        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);
        url.setCreatedAt(LocalDateTime.now());

        return urlRepository.save(url);
    }
    static String generateShortCode(){
        return UUID.randomUUID().toString().substring(0,6);
    }

    public Url getUrlByShortCode(String shortCode){
        return urlRepository.findByShortCode(shortCode).orElseThrow(() ->  new UrlNotFoundException("Url not found"));
    }

    public List<Url> getAllUrl(){
        return urlRepository.findAll();
    }
}
