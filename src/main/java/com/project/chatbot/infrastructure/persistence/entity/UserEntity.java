package com.project.chatbot.infrastructure.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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

    private boolean isAgent = false;
}
