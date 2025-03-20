package com.project.chatbot.adapters.controllers.user;

import com.project.chatbot.adapters.controllers.dto.webhook.MessageDto;
import reactor.core.publisher.Mono;

public interface WebHookController {

    Mono<MessageDto> recieveWhatsappMessage(MessageDto message);
}
