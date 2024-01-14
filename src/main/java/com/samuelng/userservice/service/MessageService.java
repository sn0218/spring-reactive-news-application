package com.samuelng.userservice.service;

import reactor.core.publisher.Mono;

public interface MessageService {
    Mono<Object> getNewsByDate(String date);
    Mono<Void> publishToMessageBroker(String date);
}
