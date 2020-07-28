package edu.fiuba.algo3.modelo.general;

public class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    public String greet() {
        return content;
    }
}
