package com.project.chatbot.infrastructure.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Builder
@Table("users")
public class UserEntity {

    @Id
    private UUID id;

    private String name;

    private String phoneNumber;

    private boolean isAgent;

    LocalDateTime createdAt;

    public UserEntity(UUID id, String name, String phoneNumber, boolean isAgent, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAgent = isAgent;
        this.createdAt = LocalDateTime.now();
    }

}
