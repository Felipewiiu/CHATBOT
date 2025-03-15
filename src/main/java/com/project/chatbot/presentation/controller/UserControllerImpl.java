package com.project.chatbot.presentation.controller;

import com.project.chatbot.adapters.controllers.dto.UserDto;
import com.project.chatbot.adapters.controllers.user.UserController;
import com.project.chatbot.application.usecases.CreateUserUseCase;
import com.project.chatbot.domain.User;
import com.project.chatbot.presentation.mapper.UserControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserControllerMapper userControllerMapper;

    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDto> create(@RequestBody UserDto userDto) {
        return createUserUseCase
                .execute(userControllerMapper.toDomain(userDto))
                .map(userControllerMapper::toDto);
    }
}
