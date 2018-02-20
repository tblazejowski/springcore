package com.blazej.messagesender.repository.inmemory;

import com.blazej.messagesender.domain.Message;
import com.blazej.messagesender.domain.MessageRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMessageRepository implements MessageRepository {

    private final List<Message> messages = new ArrayList<>();

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
