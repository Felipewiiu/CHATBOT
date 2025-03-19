package com.project.chatbot.infrastructure.mapper;

import com.project.chatbot.domain.Message;
import com.project.chatbot.infrastructure.persistence.entity.MessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageEntity toEntity(Message message);

    Message ToDomain(MessageEntity messageEntity);
}
