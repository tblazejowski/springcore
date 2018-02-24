package com.blazej.messagesender.domain;

import com.blazej.messagesender.service.MessageDto;
import org.junit.Assert;
import org.junit.Test;

public class MessageTest {

    @Test
    public void shouldCreateNewMessageWithRequiredArgs () {

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject("hot topic");
        messageDto.setBody("nice body");
        messageDto.setSender("from someone");
        messageDto.setRecipient("from someone");

        Message message = new MessageFactory().createFrom(messageDto);

        Assert.assertEquals(messageDto.getSubject(), message.getSubject());
        Assert.assertEquals(messageDto.getBody(), message.getBody());
        Assert.assertEquals(messageDto.getSender(), message.getSender());
        Assert.assertEquals(messageDto.getRecipient(), message.getRecipient());
    }
}
