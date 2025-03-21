package com.project.chatbot.application.usecases.message;

import com.project.chatbot.adapters.gateways.MessageRepositoryGateway;
import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.usecases.conversation.CreateConversationUsecase;
import com.project.chatbot.application.usecases.conversation.FindConversationByUserIdUseCase;
import com.project.chatbot.application.usecases.users.CreateUserUseCase;
import com.project.chatbot.application.usecases.users.FindUserByPhoneNumberUseCase;
import com.project.chatbot.domain.Conversation;
import com.project.chatbot.domain.Message;
import com.project.chatbot.domain.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateMessageUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateMessageUseCase.class);
    private static final UUID SYSTEM_USER_ID = UUID.fromString("279de61b-5f9e-453c-9b62-6b689f3f92fc");

    private final MessageRepositoryGateway messageRepositoryGateway;
    private final CreateUserUseCase createUserUseCase;
    private final FindUserByPhoneNumberUseCase findUserByPhoneNumberUseCase;
    private final CreateConversationUsecase createConversationUsecase;
    private final UserRepositoryGateway userRepositoryGateway;
    private final FindConversationByUserIdUseCase findConversationByUserIdUseCase;

    public Mono<Void> createMessage(String phone, String messageContent) {
        User defaultUser = buildDefaultUser(phone);
        return userRepositoryGateway.existsByPhoneNumber(phone)
                .flatMap(exists -> exists ? handleExistingUser(phone, messageContent) :
                        handleNewUser(defaultUser, messageContent));
    }

    private Mono<Void> handleNewUser(User user, String messageContent) {
        LOGGER.info("Novo usuário: {}", user);
        return createUserUseCase.execute(user)
                .flatMap(createdUser -> createConversationForUser(createdUser)
                        .flatMap(conversation -> saveMessage(conversation.getId(), createdUser.getId(), messageContent)));
    }

    private Mono<Void> handleExistingUser(String phone, String messageContent) {
        LOGGER.info("Usuário já existe com telefone: {}", phone);
        return findUserByPhoneNumberUseCase.execute(phone)
                .flatMap(user -> findConversationByUserIdUseCase.execute(user.getId())
                        .flatMap(conversation -> saveMessage(conversation.getId(), user.getId(), messageContent)));

    }

    private Mono<Conversation> createConversationForUser(User user) {
        Conversation conversation = Conversation.builder()
                .customerId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
        return createConversationUsecase.createConversation(conversation);
    }

    private Mono<Void> saveMessage(UUID conversationId, UUID senderId, String content) {
        Message message = buildMessage(conversationId, senderId, content);
        return messageRepositoryGateway.createMessage(message).then();
    }

    private User buildDefaultUser(String phone) {
        return User.builder()
                .name("cliente")
                .phoneNumber(phone)
                .build();
    }

    private Message buildMessage(UUID conversationId, UUID senderId, String content) {
        return Message.builder()
                .conversationId(conversationId)
                .content(content)
                .senderId(senderId)
                .timestamp(LocalDateTime.now())
                .build();
    }
}