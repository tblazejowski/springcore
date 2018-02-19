package com.blazej.messagesender.domain;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest {

    @Test
    public void shouldCreateNewMessageWithRequiredArgs () {

        Message message = new Message.MessageBuilder()
                .withSubject("hot topic")
                .withBody("nice body")
                .withSender("from someone")
                .withRecipient("to someone").build();

        Assert.assertEquals(message.getSubject(), "hot topic");
        Assert.assertEquals(message.getBody(), "nice body");
        Assert.assertEquals(message.getSender(), "from someone");
        Assert.assertEquals(message.getRecipient(), "to someone");
    }
}
