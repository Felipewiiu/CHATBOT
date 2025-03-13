package com.project.chatbot;

import com.project.chatbot.domain.User;

import java.util.UUID;

public class main {

    public static void main(String[] args) {
        User user = new User(UUID.randomUUID(), "John", "john@gmail.com", false);

        System.out.println(user.getId());
        user.setAgent(true);
        System.out.println(user.isAgent());
    }
}
