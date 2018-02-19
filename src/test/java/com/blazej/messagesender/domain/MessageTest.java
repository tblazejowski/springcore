package com.blazej.messagesender.domain;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest {

    @Test
    public void shouldCreateNewMessageWithRequiredArgs () {

        Message message = new Message("hot topic", "nice body", "from someone", "to someone");

        Assert.assertEquals(message.getSubject(), "hot topic");
        Assert.assertEquals(message.getBody(), "nice body");
        Assert.assertEquals(message.getSender(), "from someone");
        Assert.assertEquals(message.getRecipient(), "to someone");
    }
}
