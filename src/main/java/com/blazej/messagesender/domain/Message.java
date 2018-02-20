package com.blazej.messagesender.domain;

public class Message {

    private String subject;
    private String body;
    private String sender;
    private String recipient;

    public Message(MessageBuilder messageBuilder) {

        this.subject = messageBuilder.subject;
        this.body = messageBuilder.body;
        this.sender = messageBuilder.sender;
        this.recipient = messageBuilder.recipient;
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

    static class MessageBuilder {

        private String subject;
        private String body;
        private String sender;
        private String recipient;

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

        public Message build(){
            return new Message(this);
        }
    }
}
