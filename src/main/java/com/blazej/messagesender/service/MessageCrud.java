package com.blazej.messagesender.service;

import com.blazej.messagesender.domain.Message;
import com.blazej.messagesender.domain.MessageRepository;

public class MessageCrud {

    private final MessageRepository messageRepository;

    public MessageCrud(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String createNew(String subject, String body, String sender, String recipient){

        messageRepository.add();
        return "1";
    }
}
