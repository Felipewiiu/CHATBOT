package com.project.chatbot.infrastructure.persistence.repository;

import com.project.chatbot.domain.User;
import com.project.chatbot.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, UUID> {
    Mono<UserEntity> findByPhoneNumber(String phoneNumber);

    Mono<Boolean> existsByPhoneNumber(String phoneNumber);
}

