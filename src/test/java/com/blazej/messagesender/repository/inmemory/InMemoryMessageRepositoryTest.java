package com.blazej.messagesender.repository.inmemory;

import com.blazej.messagesender.domain.Message;
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

    @Test
    public void shouldConfirmThatFirstMessageExists(){

        Message message = new Message("some subject", "some body");

        assertTrue(repository.exists(message));
    }

    @Test
    public void shouldConfirmThatMessageSimilarToFirstDoesExist(){

        Message message = new Message("some subject", "some body");
        message.setId("some id");

        assertFalse(repository.exists(message));
    }

    @Test
    public void shouldConfirmThatSecondMessageExists(){

        Message message = new Message("hot topic", "nice body");
        message.setId("123");

        assertTrue(repository.exists(message));
    }

    @Test
    public void shouldConfirmThatMessageSimilarToSecondDoesExist(){

        Message message = new Message("hot topic", "nice body");
        message.setId("1234");

        assertFalse(repository.exists(message));
    }

    @Test
    public void shouldConfirmThatThirdMessageExists(){

        Message message = new Message("some subject", "some body");
        message.setSender("one who sends");
        message.setRecipient("one who receives");
        message.setId("890");

        assertTrue(repository.exists(message));
    }

    @Test
    public void shouldConfirmThatMessageSimilarToThirdDoesExist(){

        Message message = new Message("some subject", "some body");
        message.setSender("one who sends");
        message.setRecipient("one who sends");
        message.setId("890");

        assertFalse(repository.exists(message));
    }
}