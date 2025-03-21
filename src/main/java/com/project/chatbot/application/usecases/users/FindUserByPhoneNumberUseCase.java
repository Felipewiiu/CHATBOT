package com.project.chatbot.application.usecases.users;

import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.exeptions.NotFoundPhoneNumberException;
import com.project.chatbot.domain.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindUserByPhoneNumberUseCase {

    private final UserRepositoryGateway userRepositoryGateway;

    public Mono<User> execute(String phoneNumber) {
        return userRepositoryGateway.findUserByPhoneNumber(phoneNumber)
                .switchIfEmpty(Mono.error(new NotFoundPhoneNumberException(phoneNumber)));
    }
}
