package com.project.chatbot.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class User {

    private final UUID id = UUID.randomUUID();

    private final String name;

    private final String phoneNumber;

    private boolean isAgent = false;

    private LocalDateTime createdAt = LocalDateTime.now();


}
