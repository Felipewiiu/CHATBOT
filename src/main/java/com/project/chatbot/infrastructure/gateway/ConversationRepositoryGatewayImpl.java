package com.project.chatbot.infrastructure.gateway;

import com.project.chatbot.adapters.gateways.ConversationRepositoryGateway;
import com.project.chatbot.domain.Conversation;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ConversationRepositoryGatewayImpl implements ConversationRepositoryGateway {


    @Override
    public Mono<Void> createConversation(Conversation conversation) {
        return null;
    }
}
