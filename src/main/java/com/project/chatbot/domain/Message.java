package com.project.chatbot.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Message {

    private UUID id;

    private UUID conversationId;

    private UUID senderId;

    private String content;

    private LocalDateTime timestamp;
}
