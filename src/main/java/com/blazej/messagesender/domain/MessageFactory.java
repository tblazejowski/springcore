package com.blazej.messagesender.domain;

import com.blazej.messagesender.service.MessageDto;

public class MessageFactory {

    public static final String NO_ID = "";

    public Message createFrom (MessageDto messageDto) {
        return createFrom(messageDto, NO_ID);
    }

    public Message createFrom (MessageDto messageDto, String id) {
        return aMessageBuilder(messageDto).withId(id).build();
    }


    private Message.MessageBuilder aMessageBuilder(MessageDto messageDto) {

        return new Message.MessageBuilder()
                .withSubject(messageDto.getSubject())
                .withBody(messageDto.getBody())
                .withSender(messageDto.getSender())
                .withRecipient(messageDto.getRecipient());
    }
}
