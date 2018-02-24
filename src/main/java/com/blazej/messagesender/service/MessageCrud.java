package com.blazej.messagesender.service;

import com.blazej.messagesender.domain.Message;
import com.blazej.messagesender.domain.MessageRepository;

public class MessageCrud {

    private final MessageRepository messageRepository;

    public MessageCrud(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Response createNew(MessageDto messageDto) {

        Message message = new Message.MessageBuilder()
                .withSubject(messageDto.getSubject())
                .withBody(messageDto.getBody())
                .withSender(messageDto.getSender())
                .withRecipient(messageDto.getRecipient())
                .build();

        if (!messageRepository.exists(message)){
            message.setId("1");
            messageRepository.add(message);

            return Response.aSuccessfulResponseWith("1");
        }

        return Response.aFailureResponse("Message already exists");
    }
}