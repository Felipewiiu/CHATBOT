package com.project.chatbot.presentation.mapper;

import com.project.chatbot.adapters.controllers.dto.webhook.MessageDto;
import com.project.chatbot.domain.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageControllerMapper {

    Message toDomain(MessageDto messageDto);

    MessageDto toDto(Message message);
}
