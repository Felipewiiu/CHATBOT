package com.project.chatbot.application.usecases.users;

import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.exeptions.DuplicatePhoneException;
import com.project.chatbot.application.validators.UserValidator;
import com.project.chatbot.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepositoryGateway userRepositoryGateway;
    private final List<UserValidator> userValidators;

    public Mono<User> execute(User user) {
        return  Mono.when(userValidators.stream()
                .map(validator -> validator.validate(user)).toList()
        ).then(userRepositoryGateway.createUser(user))
                .onErrorMap(DuplicateKeyException.class, ex -> new DuplicatePhoneException());
    }
}
