package com.blazej.messagesender.domain;

public interface MessageRepository {

    boolean exists(Message message);

    boolean exists(String id);

    void add(Message message);

}
