package com.blazej.messagesender.repository.inmemory;

import com.blazej.messagesender.domain.MessageRepository;

public class InMemoryMessageRepository implements MessageRepository {

    private boolean addInvoked;

    public boolean exists(String id) {
        return addInvoked;
    }

    public void add() {
        addInvoked = true;
    }
}
