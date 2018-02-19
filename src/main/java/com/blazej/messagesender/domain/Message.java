package com.blazej.messagesender.domain;

public class Message {

    private String subject;
    private String body;
    private String sender;
    private String recipient;

    public Message(String subject, String body, String sender, String recipient) {
        this.subject = subject;
        this.body = body;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
}
