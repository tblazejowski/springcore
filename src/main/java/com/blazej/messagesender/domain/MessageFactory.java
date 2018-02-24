package com.blazej.messagesender.domain;

import com.blazej.messagesender.service.MessageDto;

public class MessageFactory {

    public Message createFrom (MessageDto messageDto){

        return new Message.MessageBuilder()
                .withSubject(messageDto.getSubject())
                .withBody(messageDto.getBody())
                .withSender(messageDto.getSender())
                .withRecipient(messageDto.getRecipient())
                .build();
    }
}
