package com.project.chatbot.infrastructure.gateway;

import com.project.chatbot.adapters.gateways.MessageRepositoryGateway;
import com.project.chatbot.domain.Message;
import com.project.chatbot.infrastructure.mapper.MessageMapper;
import com.project.chatbot.infrastructure.persistence.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class MessageRepositoryGatewayImpl implements MessageRepositoryGateway {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public Mono<Message> createMessage(Message message) {
        return messageRepository.save(messageMapper.toEntity(message))
                .map(messageMapper::ToDomain);
    }
}
