package com.yazh.url_shortener.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection="urls")
@Getter
@Setter
@NoArgsConstructor
public class Url {
    @Id
    private String id;
    private String originalUrl;
    private String shortCode;
    private LocalDateTime createdAt;
}
