package com.project.chatbot.adapters.gateways;

import reactor.core.publisher.Mono;

public interface WebHookRepositoryGateway {

    Mono<Void> receiveWhatsAppMessages(String phone, String message);
}
