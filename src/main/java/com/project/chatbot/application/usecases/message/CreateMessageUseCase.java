package com.project.chatbot.application.usecases.message;

import com.project.chatbot.adapters.gateways.MessageRepositoryGateway;
import com.project.chatbot.domain.Message;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateMessageUseCase {

    private final MessageRepositoryGateway messageRepositoryGateway;

    public Mono<Message> createMessage(Message message) {

        return messageRepositoryGateway.createMessage(message);
    }
}
