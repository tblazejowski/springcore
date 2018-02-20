package com.blazej.messagesender.service;

import com.blazej.messagesender.domain.Message;
import com.blazej.messagesender.domain.MessageRepository;

public class MessageCrud {

    private final MessageRepository messageRepository;

    public MessageCrud(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Response createNew(String subject, String body, String sender, String recipient) {

        Message message = new Message.MessageBuilder()
                .withSubject(subject)
                .withBody(body)
                .withSender(sender)
                .withRecipient(recipient)
                .build();

        if (!messageRepository.exists(message)){
            message.setId("1");
            messageRepository.add(message);

            return Response.aSuccessfulResponseWith("1");
        }

        return Response.aFailureResponse("Message already exists");
    }
}
