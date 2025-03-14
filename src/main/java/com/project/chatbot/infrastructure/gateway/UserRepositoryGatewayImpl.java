package com.project.chatbot.infrastructure.gateway;

import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.domain.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class UserRepositoryGatewayImpl implements UserRepositoryGateway {
    @Override
    public Mono<User> create(User user) {
        return null;
    }

    @Override
    public Mono<User> findById(UUID id) {
        return null;
    }
}
