package com.yazh.url_shortener.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.yazh.url_shortener.dto.CreateUrlRequest;
import com.yazh.url_shortener.dto.CreateUrlResponse;
import com.yazh.url_shortener.model.Url;
import com.yazh.url_shortener.service.UrlService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
@RequestMapping("/url")
public class UrlController {
    private final UrlService urlService;

    @PostMapping
    public CreateUrlResponse createUrl(@Valid @RequestBody CreateUrlRequest createUrlRequest) {
        Url url = urlService.createShortUrl(createUrlRequest.getOriginalUrl());
        String shortUrl = "http://localhost:8080/url/"+url.getShortCode();
        return new CreateUrlResponse(url.getShortCode(),shortUrl);
    }

    @GetMapping("/{shortCode}")
    public RedirectView getShortCode(@PathVariable String shortCode) {
        Url url = urlService.getUrlByShortCode(shortCode);
        return new RedirectView(url.getOriginalUrl());
    }

    @GetMapping
     public List<Url> getUrls() {
         return urlService.getAllUrl();
     }        
    
}
