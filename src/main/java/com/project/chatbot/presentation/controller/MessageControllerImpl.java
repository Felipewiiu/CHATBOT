package com.project.chatbot.presentation.controller;

import com.project.chatbot.adapters.controllers.dto.message.MessageDto;
import com.project.chatbot.adapters.controllers.message.MessageController;
import com.project.chatbot.application.usecases.message.CreateMessageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class MessageControllerImpl implements MessageController {

    private final CreateMessageUseCase createMessageUseCase;

    @Override
    @PostMapping
    public Mono<Void> recieveWhatsappMessage(@RequestBody MessageDto message) {
        System.out.println(message);
        return createMessageUseCase.createMessage(message.phone(), message.text());
    }
}
