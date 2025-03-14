package com.project.chatbot.infrastructure.mapper;

import com.project.chatbot.domain.User;
import com.project.chatbot.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface UserMapper {

    UserEntity toUserEntity(User user);

    User toDomain(UserEntity userEntity);


}
