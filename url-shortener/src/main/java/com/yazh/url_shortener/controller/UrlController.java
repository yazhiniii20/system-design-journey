package com.yazh.url_shortener.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yazh.url_shortener.dto.CreateUrlRequest;
import com.yazh.url_shortener.model.Url;
import com.yazh.url_shortener.service.UrlService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/url")
public class UrlController {
    private final UrlService urlService;

    @PostMapping
    public Url createUrl(@RequestBody CreateUrlRequest createUrlRequest) {
        return urlService.createShortUrl(createUrlRequest.getOriginalUrl());
    }
    
}
