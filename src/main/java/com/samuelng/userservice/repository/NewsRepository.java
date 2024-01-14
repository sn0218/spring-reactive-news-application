package com.samuelng.userservice.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface NewsRepository {
    Mono<Object> getNewsByDate(String date);
}
