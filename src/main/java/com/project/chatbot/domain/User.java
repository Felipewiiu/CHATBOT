package com.project.chatbot.domain;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@ToString
public class User {

    private final UUID id;

    private final String name;

    private final String phoneNumber;

    private boolean isAgent;

    public User(UUID id, String name, String phoneNumber, boolean isAgent) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAgent = isAgent;
    }
}
