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
public class ConversationEntity {

    @Id
    private final UUID id;

    @Builder.Default
    private final UUID userOneId = UUID.fromString("aa520be6-9c7d-422d-ac9d-1b98270b93ae");

    private final UUID userTwoId;

    private final LocalDateTime createdAt;

}
