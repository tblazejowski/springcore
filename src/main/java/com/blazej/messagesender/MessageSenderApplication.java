package com.blazej.messagesender;

import com.blazej.messagesender.service.MessageCrud;
import com.blazej.messagesender.service.MessageDto;
import com.blazej.messagesender.service.Response;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSenderApplication {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("message-sender.xml");
        MessageCrud messageCrud = (MessageCrud) context.getBean("messageCrud");

        String subject = "hot topic";
        String body = "nice body";
        String sender = "from someone";
        String recipient = "to someone";

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject(subject);
        messageDto.setBody(body);
        messageDto.setSender(sender);
        messageDto.setRecipient(recipient);

        Response response = messageCrud.createNew(messageDto);
        System.out.println(response.isSuccess());
        System.out.println(response.getMessage());

        response = messageCrud.createNew(messageDto);
        System.out.println(response.isSuccess());
        System.out.println(response.getMessage());

    }
}
