package com.yazh.url_shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUrlResponse {
    String shortCode;
    String shortUrl;
}
