package com.project.chatbot.adapters.controllers.dto;

import org.mapstruct.Builder;

import java.time.LocalDateTime;
import java.util.UUID;


public record UserDto(

        UUID id,

        String name,

        String phoneNumber,

        boolean isAgent,

        LocalDateTime createdAt

) {
}
