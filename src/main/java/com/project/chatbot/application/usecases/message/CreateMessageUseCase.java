package com.project.chatbot.application.usecases.message;

import com.project.chatbot.adapters.gateways.ConversationRepositoryGateway;
import com.project.chatbot.adapters.gateways.MessageRepositoryGateway;
import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.exeptions.NotFoundPhoneNumberException;
import com.project.chatbot.domain.Conversation;
import com.project.chatbot.domain.Message;
import com.project.chatbot.domain.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateMessageUseCase {

    private final MessageRepositoryGateway messageRepositoryGateway;
    private final UserRepositoryGateway userRepositoryGateway;
    private final ConversationRepositoryGateway conversationRepositoryGateway;

    public Mono<Message> createMessage(Message message) {

        return messageRepositoryGateway.createMessage(message);
    }
}
