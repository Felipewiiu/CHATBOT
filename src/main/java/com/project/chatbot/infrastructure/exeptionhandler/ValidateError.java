package com.project.chatbot.infrastructure.exeptionhandler;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ValidateError extends StandardError{

    private Map<String, String> fieldErrors;

}
