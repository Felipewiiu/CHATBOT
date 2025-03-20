package com.project.chatbot.application.usecases.webhook;

import com.project.chatbot.adapters.gateways.MessageRepositoryGateway;
import com.project.chatbot.adapters.gateways.UserRepositoryGateway;
import com.project.chatbot.adapters.gateways.WebHookRepositoryGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ReceiveWebookUseCase {

    private final MessageRepositoryGateway messageRepositoryGateway;
    private final UserRepositoryGateway userRepositoryGateway;
    private final WebHookRepositoryGateway webHookRepositoryGateway;

    public Mono<Void> execute(String phone, String message){
        return webHookRepositoryGateway.receiveWhatsAppMessages(phone, message);

    }
}
