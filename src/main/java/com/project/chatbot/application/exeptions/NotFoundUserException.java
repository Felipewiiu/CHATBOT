package com.project.chatbot.application.exeptions;

import java.util.UUID;

public class NotFoundUserException extends RuntimeException{
    public NotFoundUserException(UUID userId){
        super("User with id " + userId + " not found");
    }
}
