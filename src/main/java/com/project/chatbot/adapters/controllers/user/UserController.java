package com.project.chatbot.adapters.controllers.user;

import com.project.chatbot.adapters.controllers.dto.UserDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface UserController {

    Mono<ResponseEntity<UserDto>> create(UserDto user);
}
