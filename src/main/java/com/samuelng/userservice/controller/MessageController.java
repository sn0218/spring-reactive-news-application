package com.samuelng.userservice.controller;

import com.samuelng.userservice.dto.MessageResponse;
import com.samuelng.userservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("")
    public Mono<ResponseEntity<MessageResponse<Object>>> getNews(@RequestParam(name = "date") String date) {
        return messageService.getNewsByDate(date)
                .flatMap(data -> Mono.just(
                        ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageResponse<> ("Data found", true, data))))
                .switchIfEmpty(Mono.defer(() -> Mono.just(
                        ResponseEntity.status(HttpStatus.NOT_FOUND).
                                body(new MessageResponse<>
                                        ("data not found, sending request to broker", false, null)))));

    }
}
