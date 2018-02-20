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

        String id = messageCrud.createNew(subject, body, sender, recipient);

        Assert.assertThat(id, any(String.class));
        Assert.assertTrue(messageRepository.exists(id));
    }
}
