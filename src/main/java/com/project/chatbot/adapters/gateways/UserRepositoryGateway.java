package com.project.chatbot.adapters.gateways;

import com.project.chatbot.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepositoryGateway {

    Mono<User> createUser(User user);

    Mono<User> findUserById(UUID id);

    Mono<User> findUserByPhoneNumber(String phoneNumber);

    Mono<Boolean> existsByPhoneNumber(String phoneNumber);

    Flux<User> findAllUsers();
}
