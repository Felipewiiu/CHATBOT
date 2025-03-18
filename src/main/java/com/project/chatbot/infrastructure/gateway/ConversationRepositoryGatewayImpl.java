package com.project.chatbot.infrastructure.gateway;

import com.project.chatbot.adapters.gateways.ConversationRepositoryGateway;
import com.project.chatbot.domain.Conversation;
import com.project.chatbot.infrastructure.mapper.ConversationMapper;
import com.project.chatbot.infrastructure.persistence.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ConversationRepositoryGatewayImpl implements ConversationRepositoryGateway {

    private final ConversationRepository conversationRepository;
    private final ConversationMapper conversationMapper;

    @Override
    public Mono<Conversation> createConversation(Conversation conversation) {
      return conversationRepository.save(conversationMapper.toEntity(conversation))
              .map(conversationMapper::toDomain);
    }
}
