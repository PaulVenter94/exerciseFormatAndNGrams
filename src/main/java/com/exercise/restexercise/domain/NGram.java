package com.exercise.restexercise.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NGram {
    private String ngram;
    private int count;
    @JsonIgnore
    private int numberOfWords;

    public NGram(String ngram, int count, int numberOfWords) {
        this.ngram = ngram;
        this.count = count;
        this.numberOfWords = numberOfWords;
    }

    public String getNgram() {
        return ngram;
    }

    public void setNgram(String ngram) {
        this.ngram = ngram;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(int numberOfWords) {
        this.numberOfWords = numberOfWords;
    }


    @Override
    public String toString() {
        return "NGram{" +
                "ngram='" + ngram + '\'' +
                ", count=" + count +
                ", numberOfWords=" + numberOfWords +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NGram nGram = (NGram) o;

        if (count != nGram.count) return false;
        if (numberOfWords != nGram.numberOfWords) return false;
        return ngram != null ? ngram.equals(nGram.ngram) : nGram.ngram == null;
    }

    @Override
    public int hashCode() {
        int result = ngram != null ? ngram.hashCode() : 0;
        result = 31 * result + count;
        result = 31 * result + numberOfWords;
        return result;
    }
}
