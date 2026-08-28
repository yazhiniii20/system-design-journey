package com.yazh.url_shortener.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.yazh.url_shortener.model.Url;

public interface UrlRepository extends MongoRepository<Url,String>{
    Optional<Url> findByShortCode(String shortCode);
    boolean existsByShortCode(String shortCode);
}
