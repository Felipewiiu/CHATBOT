package com.project.chatbot.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class Conversation {

    private final UUID id;

    private final UUID agentId;

    private final UUID customerId;

    @Builder.Default
    private final LocalDateTime createdAt = LocalDateTime.now();


}
