package com.project.chatbot.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Builder
@ToString
public class Message {

    private final UUID id;

    private final UUID conversationId;

    private final UUID senderId;

    private final String content;

    private final LocalDateTime timestamp;

    public Message(UUID id, UUID conversationId, UUID senderId, String content, LocalDateTime timestamp) {
        this.id = id;
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.content = content;
        this.timestamp = timestamp;
    }
}
