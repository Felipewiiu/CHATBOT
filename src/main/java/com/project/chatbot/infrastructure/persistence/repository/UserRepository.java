package com.project.chatbot.infrastructure.persistence.repository;

import com.project.chatbot.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
}
