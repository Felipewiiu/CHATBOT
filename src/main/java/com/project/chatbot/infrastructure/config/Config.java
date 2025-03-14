package com.project.chatbot.infrastructure.config;

import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.usecases.CreateUserUseCase;
import com.project.chatbot.infrastructure.gateway.UserRepositoryGatewayImpl;
import com.project.chatbot.infrastructure.mapper.UserMapper;
import com.project.chatbot.infrastructure.persistence.repository.UserRepository;
import com.project.chatbot.presentation.controller.UserControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {



    @Bean
    UserControllerImpl customUserController(CreateUserUseCase createUserUseCase) {
        return new UserControllerImpl(createUserUseCase);
    }

    @Bean
    UserRepositoryGatewayImpl customUserRepositoryGateway(UserRepository userRepository, UserMapper userMapper) {
        return new UserRepositoryGatewayImpl(userRepository, userMapper);
    }
}
