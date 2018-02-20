package com.blazej.messagesender.service;

import com.blazej.messagesender.domain.Message;
import com.blazej.messagesender.domain.MessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/message-sender.xml")
public class MessageCrudTest {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageCrud messageCrud;

    @Test
    public void shouldCreateNewMessage() {

        String subject = "hot topic";
        String body = "nice body";
        String sender = "from someone";
        String recipient = "to someone";

        Response response = messageCrud.createNew(subject, body, sender, recipient);

        Assert.assertTrue(response.isSuccess());
        Assert.assertThat(response.getMessage(), any(String.class));
        Assert.assertTrue(messageRepository.exists(response.getMessage()));
    }

    @Test
    public void shouldNotCreateNewMessage() {

        String subject = "hot topic";
        String body = "nice body";
        String sender = "from someone";
        String recipient = "to someone";

        messageRepository.add(new Message.MessageBuilder()
                        .withSubject(subject)
                        .withBody(body)
                        .withSender(sender)
                        .withRecipient(recipient)
                        .build());

        Response response = messageCrud.createNew(subject, body, sender, recipient);

        Assert.assertFalse(response.isSuccess());
    }
}
