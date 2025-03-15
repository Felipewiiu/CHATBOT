package com.project.chatbot.infrastructure.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
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

    public UserEntity(String name, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAgent = false;
        this.createdAt = LocalDateTime.now();
    }
}
