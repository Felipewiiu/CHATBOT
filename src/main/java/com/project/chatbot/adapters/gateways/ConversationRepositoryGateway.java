package com.project.chatbot.adapters.gateways;

import com.project.chatbot.domain.Conversation;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ConversationRepositoryGateway {

    Mono<Conversation> createConversation(Conversation conversation);

    Mono<Conversation> findByUserId(UUID userId);
}
