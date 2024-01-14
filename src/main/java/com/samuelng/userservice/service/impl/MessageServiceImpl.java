package com.samuelng.userservice.service.impl;

import com.samuelng.userservice.repository.NewsRepository;
import com.samuelng.userservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private NewsRepository newsRepository;



    @Override
    public Mono<Object> getNewsByDate(String date) {

        return newsRepository.getNewsByDate(date)
                .flatMap(news -> Mono.just(news));
    }

    @Override
    public Mono<Void> publishToMessageBroker(String date) {
        return null;
    }
}
