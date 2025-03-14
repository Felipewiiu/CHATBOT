package com.project.chatbot.adapters.controllers.dto;

import java.util.UUID;

public record UserDto(

        UUID id,

        String name,

        String phoneNumber
) {
}
