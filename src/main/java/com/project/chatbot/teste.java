package com.project.chatbot;

import com.project.chatbot.infrastructure.persistence.entity.UserEntity;

public class teste {

    public static void main(String[] args) {
        UserEntity user = UserEntity.builder()
                        .name("felipe")
                                .build();

        System.out.println( user.isAgent());
    }
}
