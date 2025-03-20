package com.project.chatbot.infrastructure.config;

import com.project.chatbot.adapters.gateways.ConversationRepositoryGateway;
import com.project.chatbot.adapters.gateways.MessageRepositoryGateway;
import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.usecases.conversation.CreateConversationUsecase;
import com.project.chatbot.application.usecases.message.CreateMessageUseCase;
import com.project.chatbot.application.usecases.users.CreateUserUseCase;
import com.project.chatbot.application.usecases.users.FindByPhoneNumberUseCase;
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
    FindByPhoneNumberUseCase customFindByPhoneNumberUseCase(UserRepositoryGateway userRepositoryGateway){
        return new FindByPhoneNumberUseCase(userRepositoryGateway);
    }

    @Bean
    IntegrityUserValidator customIntegrityUserValidator(){
        return new IntegrityUserValidator();
    }

    @Bean
    CreateMessageUseCase customCreateMessageUseCase(MessageRepositoryGateway messageRepositoryGateway,
                                                    CreateUserUseCase createUserUseCase,
                                                    FindByPhoneNumberUseCase findByPhoneNumberUseCase,
                                                    CreateConversationUsecase createConversationUsecase,
                                                    UserRepositoryGateway userRepositoryGateway){
        return new CreateMessageUseCase(messageRepositoryGateway,
                createUserUseCase, findByPhoneNumberUseCase, createConversationUsecase, userRepositoryGateway);
    }

    @Bean
    CreateConversationUsecase customCreateConversationUsecase(ConversationRepositoryGateway conversationRepositoryGateway){
        return new CreateConversationUsecase(conversationRepositoryGateway);
    }

}
