package com.project.chatbot.application.usecases.conversation;

import com.project.chatbot.adapters.gateways.ConversationRepositoryGateway;
import com.project.chatbot.domain.Conversation;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateConversationUsecase {

    private final ConversationRepositoryGateway conversationRepositoryGateway;

    public Mono<Conversation> createConversation(Conversation conversation) {
        return conversationRepositoryGateway.createConversation(conversation);
    }

}
