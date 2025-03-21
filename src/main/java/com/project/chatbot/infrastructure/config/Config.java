package com.project.chatbot.infrastructure.config;

import com.project.chatbot.adapters.gateways.ConversationRepositoryGateway;
import com.project.chatbot.adapters.gateways.MessageRepositoryGateway;
import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.application.usecases.conversation.CreateConversationUsecase;
import com.project.chatbot.application.usecases.conversation.FindConversationByUserIdUseCase;
import com.project.chatbot.application.usecases.message.CreateMessageUseCase;
import com.project.chatbot.application.usecases.users.CreateUserUseCase;
import com.project.chatbot.application.usecases.users.FindUserByPhoneNumberUseCase;
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
    FindUserByPhoneNumberUseCase customFindByPhoneNumberUseCase(UserRepositoryGateway userRepositoryGateway){
        return new FindUserByPhoneNumberUseCase(userRepositoryGateway);
    }

    @Bean
    IntegrityUserValidator customIntegrityUserValidator(){
        return new IntegrityUserValidator();
    }

    @Bean
    CreateMessageUseCase customCreateMessageUseCase(MessageRepositoryGateway messageRepositoryGateway,
                                                    CreateUserUseCase createUserUseCase,
                                                    FindUserByPhoneNumberUseCase findUserByPhoneNumberUseCase,
                                                    CreateConversationUsecase createConversationUsecase,
                                                    UserRepositoryGateway userRepositoryGateway,
                                                    FindConversationByUserIdUseCase findConversationByUserIdUseCase){
        return new CreateMessageUseCase(messageRepositoryGateway,
                createUserUseCase, findUserByPhoneNumberUseCase, createConversationUsecase, userRepositoryGateway, findConversationByUserIdUseCase);
    }

    @Bean
    CreateConversationUsecase customCreateConversationUsecase(ConversationRepositoryGateway conversationRepositoryGateway){
        return new CreateConversationUsecase(conversationRepositoryGateway);
    }

    @Bean
    FindConversationByUserIdUseCase customFindConversationByUserIdUseCase(ConversationRepositoryGateway conversationRepositoryGateway){
        return new FindConversationByUserIdUseCase(conversationRepositoryGateway);
    }

}
