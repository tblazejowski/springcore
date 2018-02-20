package com.blazej.messagesender.domain;

public interface MessageRepository {

    boolean exists(String id);

    void add();

}
