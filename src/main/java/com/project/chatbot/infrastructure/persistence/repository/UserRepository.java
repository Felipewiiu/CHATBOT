package com.project.chatbot.infrastructure.persistence.repository;

import com.project.chatbot.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, UUID> {
}
