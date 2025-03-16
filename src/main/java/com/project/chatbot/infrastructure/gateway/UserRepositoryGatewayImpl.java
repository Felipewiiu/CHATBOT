package com.project.chatbot.infrastructure.gateway;

import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.exeptions.DuplicatePhoneException;
import com.project.chatbot.domain.User;
import com.project.chatbot.infrastructure.mapper.UserMapper;
import com.project.chatbot.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class UserRepositoryGatewayImpl implements UserRepositoryGateway {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.save(userMapper.toUserEntity(user))
                .map(userMapper::toDomain);
    }

    @Override
    public Mono<User> findUserById(UUID id) {
        return null;
    }

    @Override
    public Flux<User> findAllUsers() {
        return null;
    }


}
