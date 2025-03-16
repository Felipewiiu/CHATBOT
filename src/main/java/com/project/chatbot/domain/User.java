package com.project.chatbot.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class User {

    private final UUID id;

    private final String name;

    private final String phoneNumber;

    private boolean isAgent;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}
