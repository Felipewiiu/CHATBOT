package com.project.chatbot.application.validators;

import com.project.chatbot.domain.User;
import jakarta.validation.ValidationException;
import reactor.core.publisher.Mono;

public class IntegrityUserValidator implements UserValidator {
    @Override
    public Mono<Void> validate(User user) {
        return Mono.fromRunnable(() -> {

            if(user.getName() == null || user.getName().isBlank()) {
                throw new ValidationException("Name is required");
            }

            if(user.getPhoneNumber() == null || user.getPhoneNumber().isBlank()) {
                throw new ValidationException("Phone number is required");
            }

        });
    }
}
