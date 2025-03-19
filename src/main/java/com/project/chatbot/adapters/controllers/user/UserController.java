package com.project.chatbot.adapters.controllers.user;

import com.project.chatbot.adapters.controllers.dto.UserDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserController {

    Mono<ResponseEntity<UserDto>> create(UserDto user);

    Mono<ResponseEntity<UserDto>> findById(UUID id);

    Mono<ResponseEntity<UserDto>> findByPhoneNumber(String phoneNumber);
}
