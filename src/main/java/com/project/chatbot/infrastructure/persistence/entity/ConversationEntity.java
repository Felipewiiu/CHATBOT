package com.project.chatbot.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Table("conversations")
@AllArgsConstructor
public class ConversationEntity {

    @Id
    private final UUID id;

    private final UUID userOneId;

    private final UUID userTwoId;

    private final LocalDateTime createdAt;

}
