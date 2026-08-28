package com.yazh.url_shortener.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUrlRequest {
    private String originalUrl;
}
