package com.project.chatbot.infrastructure.gateway;

import com.project.chatbot.adapters.gateways.WebHookRepositoryGateway;
import com.project.chatbot.infrastructure.persistence.repository.ConversationRepository;
import com.project.chatbot.infrastructure.persistence.repository.MessageRepository;
import com.project.chatbot.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class WebHookRepositoryGatewayImpl implements WebHookRepositoryGateway {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    @Override
    public Mono<Void> receiveWhatsAppMessages(String phone, String message) {
        return null;
    }
}
