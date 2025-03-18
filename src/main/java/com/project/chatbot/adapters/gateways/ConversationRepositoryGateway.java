package com.project.chatbot.adapters.gateways;

import com.project.chatbot.domain.Conversation;
import reactor.core.publisher.Mono;

public interface ConversationRepositoryGateway {

    Mono<Void> createConversation(Conversation conversation);
}
