package com.project.chatbot.application.exeptions;

public class DuplicatePhoneException extends RuntimeException {

    public DuplicatePhoneException() {
        super("Phone number already in use");
    }
}
