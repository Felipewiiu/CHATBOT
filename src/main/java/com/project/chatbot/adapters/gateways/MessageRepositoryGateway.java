package com.project.chatbot.adapters.gateways;

import com.project.chatbot.adapters.controllers.dto.webhook.MessageDto;
import com.project.chatbot.domain.Message;
import reactor.core.publisher.Mono;

public interface MessageRepositoryGateway {

    Mono<Message> createMessage(Message message);
}
