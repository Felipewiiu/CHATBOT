package com.project.chatbot.infrastructure.config;

import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.usecases.CreateUserUseCase;
import com.project.chatbot.application.validators.UserValidator;
import com.project.chatbot.infrastructure.gateway.UserRepositoryGatewayImpl;
import com.project.chatbot.infrastructure.mapper.UserMapper;
import com.project.chatbot.infrastructure.persistence.repository.UserRepository;
import com.project.chatbot.presentation.controller.UserControllerImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {


    @Bean
    UserRepositoryGatewayImpl customUserRepositoryGatewayImpl(UserRepository userRepository, UserMapper userMapper) {
        return new UserRepositoryGatewayImpl(userRepository, userMapper);
    }

    @Bean
    CreateUserUseCase customCreateUserUseCase(
            @Qualifier("customUserRepositoryGatewayImpl") UserRepositoryGateway userRepositoryGateway,
            List<UserValidator> listUserValidation
    ) {
        return new CreateUserUseCase(userRepositoryGateway, listUserValidation);
    }
}
