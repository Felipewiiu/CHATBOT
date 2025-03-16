package com.project.chatbot.adapters.controllers.dto;

import java.time.LocalDateTime;


public record UserDto(

        String name,

        String phoneNumber,

        boolean isAgent,

        LocalDateTime createdAt

) {
}
