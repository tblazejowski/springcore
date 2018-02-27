package com.blazej.messagesender.repository.inmemory;

import com.blazej.messagesender.domain.Message;
import com.blazej.messagesender.domain.MessageFactory;
import com.blazej.messagesender.service.MessageDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/repositories.xml")
public class InMemoryMessageRepositoryTest {

    @Autowired
    private InMemoryMessageRepository repository;
    private MessageFactory messageFactory = new MessageFactory();

    @Test
    public void shouldConfirmThatFirstMessageExists(){

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject("some subject");
        messageDto.setBody("some body");

        assertTrue(repository.exists(messageFactory.createFrom(messageDto)));
    }

    @Test
    public void shouldConfirmThatMessageSimilarToFirstDoesExist(){

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject("some subject");
        messageDto.setBody("some body");

        assertFalse(repository.exists(messageFactory.createFrom(messageDto, "some id")));
    }

    @Test
    public void shouldConfirmThatSecondMessageExists(){

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject("hot topic");
        messageDto.setBody("nice body");

        assertTrue(repository.exists(messageFactory.createFrom(messageDto, "123")));
    }

    @Test
    public void shouldConfirmThatMessageSimilarToSecondDoesExist(){

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject("hot topic");
        messageDto.setBody("nice body");

        assertFalse(repository.exists(messageFactory.createFrom(messageDto, "1234")));
    }

    @Test
    public void shouldConfirmThatThirdMessageExists(){

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject("some subject");
        messageDto.setBody("some body");
        messageDto.setSender("one who sends");
        messageDto.setRecipient("one who receives");

        assertTrue(repository.exists(messageFactory.createFrom(messageDto, "890")));
    }

    @Test
    public void shouldConfirmThatMessageSimilarToThirdDoesExist(){

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject("some subject");
        messageDto.setBody("some body");
        messageDto.setSender("one who receives");
        messageDto.setRecipient("one who sends");

        assertFalse(repository.exists(messageFactory.createFrom(messageDto, "890")));
    }

    @Test
    public void shouldConfirmThatFourthMessageExists(){

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject("long subject");
        messageDto.setBody("short body");

        assertTrue(repository.exists(messageFactory.createFrom(messageDto)));
    }
}