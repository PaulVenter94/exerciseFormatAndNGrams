package com.exercise.restexercise.domain;

public class PhraseBody {
    private String text;

    public PhraseBody(){

    }
    public PhraseBody(String text) {
        this.text = text == null ? "" : text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Body{" +
                "text='" + text + '\'' +
                '}';
    }
}
