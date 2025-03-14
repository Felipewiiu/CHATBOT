package com.project.chatbot.application.validators;

import com.project.chatbot.domain.User;
import reactor.core.publisher.Mono;

public interface UserValidator {
    Mono<Void> validate(User user);
}
