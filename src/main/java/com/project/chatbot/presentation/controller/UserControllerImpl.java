package com.project.chatbot.presentation.controller;

import com.project.chatbot.adapters.controllers.dto.UserDto;
import com.project.chatbot.adapters.controllers.user.UserController;
import com.project.chatbot.application.usecases.CreateUserUseCase;
import com.project.chatbot.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final CreateUserUseCase createUserUseCase;

    @Override
    @PostMapping("/create")
    public Mono<UserDto> create(User user) {
        return null;
    }
}
