package com.blazej.messagesender.repository.inmemory;

import com.blazej.messagesender.domain.Message;
import com.blazej.messagesender.domain.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryMessageRepository implements MessageRepository {

    private List<Message> messages;

    public InMemoryMessageRepository(){
        this(new ArrayList<>());
    }

    public InMemoryMessageRepository(List<Message> messages) {
        this.messages = messages;
    }

    public boolean exists(String id) {
        return messages.stream().anyMatch(message -> message.hasSameId(id));
    }

    public boolean exists(Message message) {
        return messages.contains(message);
    }

    public void add(Message message) {
        messages.add(message);
    }
}
