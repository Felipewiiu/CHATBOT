package com.project.chatbot.application.usecases.message;

import com.project.chatbot.adapters.gateways.MessageRepositoryGateway;
import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.usecases.conversation.CreateConversationUsecase;
import com.project.chatbot.application.usecases.users.CreateUserUseCase;
import com.project.chatbot.application.usecases.users.FindByPhoneNumberUseCase;
import com.project.chatbot.domain.Conversation;
import com.project.chatbot.domain.Message;
import com.project.chatbot.domain.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateMessageUseCase {

    private final MessageRepositoryGateway messageRepositoryGateway;
    private final CreateUserUseCase createUserUseCase;
    private final FindByPhoneNumberUseCase findByPhoneNumberUseCase;
    private final CreateConversationUsecase createConversationUsecase;
    private final UserRepositoryGateway userRepositoryGateway;

    public Mono<Void> createMessage(String phone, String messageContent) {
        User user = User.builder().name("cliente").phoneNumber(phone).build();

        return userRepositoryGateway.existsByPhoneNumber(phone)
                .flatMap(exists -> {
                    if (!exists) {
                        return createUserUseCase.execute(user)
                                .flatMap( newUser -> {
                                    Conversation conversation = Conversation.builder()
                                            .userOneId(UUID.fromString("698b1b94-07e9-4f8f-9854-514911b7ef06"))
                                            .userTwoId(newUser.getId())
                                            .createdAt(LocalDateTime.now())
                                            .build();
                                   return createConversationUsecase.createConversation(conversation)
                                            .flatMap( conversation1 -> {
                                                Message message = Message.builder()
                                                        .conversationId(conversation1.getId())
                                                        .content(messageContent)
                                                        .senderId(newUser.getId())
                                                        .timestamp(LocalDateTime.now())
                                                        .build();
                                               return messageRepositoryGateway.createMessage(message);
                                            } ).then(Mono.empty());
                                } ).then(Mono.empty());

                    } else {
                        System.out.println("Usuário já existe");

                        return Mono.empty();
                    }
                });



    }
}
