package com.exercise.restexercise.domain;

public class NGramBody {
    private int maxNGramCount;
    private String text;

    public int getMaxNGramCount() {
        return maxNGramCount;
    }

    public void setMaxNGramCount(int maxNGramCount) {
        this.maxNGramCount = maxNGramCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "NgramBody{" +
                "maxNGramCount=" + maxNGramCount +
                ", text='" + text + '\'' +
                '}';
    }
}
