package com.project.chatbot.presentation.controller;

import com.project.chatbot.adapters.controllers.dto.webhook.MessageDto;
import com.project.chatbot.adapters.controllers.user.WebHookController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class WebHookControllerImpl implements WebHookController {

    @Override
    @PostMapping
    public Mono<MessageDto> recieveWhatsappMessage(@RequestBody MessageDto message) {
        System.out.println(message.phone());

        return Mono.just(message);
    }
}
