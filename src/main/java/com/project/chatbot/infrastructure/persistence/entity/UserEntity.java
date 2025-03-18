package com.project.chatbot.infrastructure.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Table("users")
public class UserEntity {

    @Id
    private final UUID id;

    private final String name;

    private final String phoneNumber;

    private final boolean isAgent;

    private final LocalDateTime createdAt;

    public UserEntity(UUID id, String name, String phoneNumber, boolean isAgent, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAgent = isAgent;
        this.createdAt = LocalDateTime.now();
    }

}
