package com.project.chatbot.infrastructure.persistence.repository;

import com.project.chatbot.domain.Conversation;
import com.project.chatbot.infrastructure.persistence.entity.ConversationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface ConversationRepository extends ReactiveCrudRepository<ConversationEntity, UUID> {
    Mono<Conversation> findByUserTwoId(UUID userTwoId);
}
