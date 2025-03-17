package com.project.chatbot.application.usecases.users;

import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.exeptions.NotFoundUserException;
import com.project.chatbot.domain.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class FindUserByIdUseCase {

    private final UserRepositoryGateway userRepositoryGateway;

    public Mono<User> execute(UUID userId) {
        return userRepositoryGateway.findUserById(userId)
                .switchIfEmpty(Mono.error(new NotFoundUserException(userId)));
    }
}
