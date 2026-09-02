package com.yazh.url_shortener.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUrlRequest {

    @NotBlank(message = "Original Url cannot be empty")
    private String originalUrl;
}
