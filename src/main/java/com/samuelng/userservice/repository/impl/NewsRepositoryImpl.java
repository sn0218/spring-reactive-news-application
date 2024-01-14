package com.samuelng.userservice.repository.impl;

import com.samuelng.userservice.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class NewsRepositoryImpl implements NewsRepository {

    @Autowired
    ReactiveRedisOperations<String, Object> redisOperationsCustom;

    @Override
    public Mono<Object> getNewsByDate(String date) {
        return redisOperationsCustom.opsForValue().get(date);
    }

}
