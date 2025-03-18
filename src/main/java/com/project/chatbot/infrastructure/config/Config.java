package com.project.chatbot.infrastructure.config;

import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.usecases.users.CreateUserUseCase;
import com.project.chatbot.application.usecases.users.FindUserByIdUseCase;
import com.project.chatbot.application.validators.IntegrityUserValidator;
import com.project.chatbot.application.validators.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    CreateUserUseCase customCreateUserUseCase(UserRepositoryGateway userRepositoryGateway, List<UserValidator> listUserValidation) {
        return new CreateUserUseCase(userRepositoryGateway, listUserValidation);
    }

    @Bean
    FindUserByIdUseCase customFindUserByIdUseCase(UserRepositoryGateway userRepositoryGateway){
        return new FindUserByIdUseCase(userRepositoryGateway);
    }

    @Bean
    IntegrityUserValidator customIntegrityUserValidator(UserRepositoryGateway userRepositoryGateway){
        return new IntegrityUserValidator();
    }

}
