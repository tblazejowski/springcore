package com.blazej.messagesender.domain;

public class Message {

    private final String subject;
    private final String body;
    private final String sender;
    private final String recipient;
    private String id;

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
        return recipient.equals(message.recipient);
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

    public boolean hasSameId(String id){
        return this.id == id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class MessageBuilder {

        private String subject;
        private String body;
        private String sender;
        private String recipient;
        public String id;

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

        public Message build(){
            return new Message(this);
        }
    }
}
