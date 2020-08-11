package com.exercise.restexercise.domain;

public class Phrase {
    private final int srcTokensNumber;
    private final int trgTokensNumber;
    private final String srcTokens;
    private final String trgTokens;
    private final String otherInfo;

    public Phrase(int srcTokensNumber, int trgTokensNumber, String srcTokens, String trgTokens, String otherInfo) {
        this.srcTokensNumber = srcTokensNumber;
        this.trgTokensNumber = trgTokensNumber;
        this.srcTokens = srcTokens == null ? "" : srcTokens;
        this.trgTokens = trgTokens == null ? "" : trgTokens;
        this.otherInfo = otherInfo == null ? "" : otherInfo;
    }

    public int getSrcTokensNumber() {
        return srcTokensNumber;
    }

    public int getTrgTokensNumber() {
        return trgTokensNumber;
    }

    public String getSrcTokens() {
        return srcTokens;
    }

    public String getTrgTokens() {
        return trgTokens;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phrase phrase = (Phrase) o;

        if (srcTokens != null ? !srcTokens.equals(phrase.srcTokens) : phrase.srcTokens != null) return false;
        if (trgTokens != null ? !trgTokens.equals(phrase.trgTokens) : phrase.trgTokens != null) return false;
        return otherInfo != null ? otherInfo.equals(phrase.otherInfo) : phrase.otherInfo == null;
    }

    @Override
    public int hashCode() {
        int result = srcTokens != null ? srcTokens.hashCode() : 0;
        result = 31 * result + (trgTokens != null ? trgTokens.hashCode() : 0);
        result = 31 * result + (otherInfo != null ? otherInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "srcTokensNumber=" + srcTokensNumber +
                ", trgTokensNumber=" + trgTokensNumber +
                ", srcTokens='" + srcTokens + '\'' +
                ", trgTokens='" + trgTokens + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }
}
