package com.project.chatbot.infrastructure.mapper;

import com.project.chatbot.domain.Conversation;
import com.project.chatbot.infrastructure.persistence.entity.ConversationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConversationMapper {

    Conversation toDomain(ConversationEntity conversationEntity);

    ConversationEntity toEntity(Conversation conversation);

}
