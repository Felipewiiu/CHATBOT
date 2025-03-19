package com.project.chatbot.application.exeptions;

public class NotFoundPhoneNumberException extends RuntimeException {
    public NotFoundPhoneNumberException(String message) {
        super("Phone number not found: " + message);
    }
}
