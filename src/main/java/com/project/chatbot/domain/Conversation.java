package com.project.chatbot.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@ToString
public class Conversation {

    private final UUID id;

    private final UUID userOneId;

    private final UUID userTwoId;

    private final LocalDateTime createdAt;

    public Conversation(UUID id, UUID userOneId, UUID userTwoId, LocalDateTime createdAt) {
        this.id = id;
        this.userOneId = userOneId;
        this.userTwoId = userTwoId;
        this.createdAt = createdAt;
    }
}
