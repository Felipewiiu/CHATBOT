package com.project.chatbot.presentation.controller;

import com.project.chatbot.adapters.controllers.dto.user.UserDto;
import com.project.chatbot.adapters.controllers.user.UserController;
import com.project.chatbot.application.usecases.users.CreateUserUseCase;
import com.project.chatbot.application.usecases.users.FindByPhoneNumberUseCase;
import com.project.chatbot.application.usecases.users.FindUserByIdUseCase;
import com.project.chatbot.presentation.mapper.UserControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserControllerMapper userControllerMapper;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindByPhoneNumberUseCase findByPhoneNumberUseCase;

    @Override
    @PostMapping("/create")
    public Mono<ResponseEntity<UserDto>> create(@RequestBody UserDto userDto) {
        return createUserUseCase.execute(userControllerMapper.toDomain(userDto))
                .map(user -> new ResponseEntity<>(userControllerMapper.toDto(user), HttpStatus.CREATED));
    }

    @Override
    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserDto>> findById(@PathVariable("id") UUID id) {
        return findUserByIdUseCase.execute(id)
                .map(user -> new ResponseEntity<>(userControllerMapper.toDto(user), HttpStatus.OK));
    }

    @Override
    @GetMapping("/phone/{phone}")
    public Mono<ResponseEntity<UserDto>> findByPhoneNumber(@PathVariable("phone") String phoneNumber) {
        return findByPhoneNumberUseCase.execute(phoneNumber)
                .map(user-> new ResponseEntity<>(userControllerMapper.toDto(user), HttpStatus.OK));
    }
}