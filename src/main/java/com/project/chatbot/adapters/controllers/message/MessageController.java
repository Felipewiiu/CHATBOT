package com.project.chatbot.adapters.controllers.message;

import com.project.chatbot.adapters.controllers.dto.message.MessageDto;
import reactor.core.publisher.Mono;

public interface MessageController {

    Mono<Void> recieveWhatsappMessage(MessageDto message);
}
