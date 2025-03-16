package com.project.chatbot.presentation.controller;

import com.project.chatbot.adapters.controllers.dto.UserDto;
import com.project.chatbot.adapters.controllers.user.UserController;
import com.project.chatbot.application.exeptions.DuplicatePhoneException;
import com.project.chatbot.application.usecases.users.CreateUserUseCase;
import com.project.chatbot.presentation.mapper.UserControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Mono<ResponseEntity<UserDto>> create(@RequestBody UserDto userDto) {
        return createUserUseCase.execute(userControllerMapper.toDomain(userDto))
                .map(user -> new ResponseEntity<>(userControllerMapper.toDto(user), HttpStatus.CREATED));
    }
}