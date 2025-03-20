package com.project.chatbot.application.usecases.conversation;

import com.project.chatbot.adapters.gateways.ConversationRepositoryGateway;
import com.project.chatbot.application.exeptions.NotFoundUserException;
import com.project.chatbot.domain.Conversation;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class FindConversationByUserIdUseCase {

    private final ConversationRepositoryGateway conversationRepositoryGateway;

    public Mono<Conversation> execute(UUID userId) {
       return conversationRepositoryGateway.findByUserId(userId)
               .switchIfEmpty(Mono.error( new NotFoundUserException(userId)));
    }
}
