package com.blazej.messagesender.domain;

public class Message {

    public static final String NO_VALUE = "";
    private String subject = NO_VALUE;
    private String body = NO_VALUE;
    private String sender = NO_VALUE;
    private String recipient = NO_VALUE;
    private String id = NO_VALUE;

    public Message(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setId(String id) {
        this.id = id;
    }

    Message(MessageBuilder messageBuilder) {

        this.subject = messageBuilder.subject;
        this.body = messageBuilder.body;
        this.sender = messageBuilder.sender;
        this.recipient = messageBuilder.recipient;
        this.id = messageBuilder.id;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!subject.equals(message.subject)) return false;
        if (!body.equals(message.body)) return false;
        if (!sender.equals(message.sender)) return false;
        if (!recipient.equals(message.recipient)) return false;
        return id.equals(message.id);
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

    public boolean hasSameId(String id) {
        return this.id == id;
    }

    public static class MessageBuilder {

        private static final String NO_ID = NO_VALUE;

        private String subject;
        private String body;
        private String sender;
        private String recipient;
        public String id = NO_ID;

        public MessageBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public MessageBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public MessageBuilder withSender(String sender) {
            this.sender = sender;
            return this;
        }

        public MessageBuilder withRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public MessageBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
