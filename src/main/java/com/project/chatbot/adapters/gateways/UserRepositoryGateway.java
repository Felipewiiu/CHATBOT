package com.project.chatbot.adapters.gateways;

import com.project.chatbot.domain.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepositoryGateway {

    Mono<User> createUser(User user);

    Mono<User> findById(UUID id);
}
