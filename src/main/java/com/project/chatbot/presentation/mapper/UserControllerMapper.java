package com.project.chatbot.presentation.mapper;

import com.project.chatbot.adapters.controllers.dto.user.UserDto;
import com.project.chatbot.domain.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface UserControllerMapper {

    UserDto toDto(User user);

    User toDomain(UserDto userDto);
}
