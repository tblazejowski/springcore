package com.blazej.messagesender.service;

public class Response {

    public static final boolean SUCCESS = true;
    public static final boolean FAILURE = false;

    private final boolean success;
    private final String message;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    static Response aSuccessfulResponseWith(String message){
        return new Response(SUCCESS, message);
    }

    static Response aFailureResponse(String message){
        return new Response(FAILURE, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
