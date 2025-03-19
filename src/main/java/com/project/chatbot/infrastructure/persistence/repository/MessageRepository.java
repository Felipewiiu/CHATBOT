package com.project.chatbot.infrastructure.persistence.repository;

import com.project.chatbot.infrastructure.persistence.entity.MessageEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface MessageRepository extends ReactiveCrudRepository<MessageEntity, UUID> {
}
