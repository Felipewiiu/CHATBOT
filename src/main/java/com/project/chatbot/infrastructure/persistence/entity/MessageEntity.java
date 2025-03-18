package com.project.chatbot.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("messages")
@Builder
@Getter
@AllArgsConstructor
public class MessageEntity {

    private final UUID id;

    private final UUID conversationId;

    private final UUID senderId;

    private final String content;

    private final LocalDateTime timestamp;

}
