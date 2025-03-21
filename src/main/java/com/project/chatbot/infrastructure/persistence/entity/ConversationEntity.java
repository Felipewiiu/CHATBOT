package com.project.chatbot.infrastructure.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Table("conversations")
public class ConversationEntity {

    @Id
    private final UUID id;

    private final UUID agentId;

    private final UUID customerId;

    @Builder.Default
    private final LocalDateTime createdAt = LocalDateTime.now();

}
