package com.exercise.restexercise.services;

import com.exercise.restexercise.domain.Phrase;
import com.exercise.restexercise.domain.PhraseBody;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MungingService {


    public PhraseBody format(PhraseBody phraseBody) {
        System.out.println(phraseBody);
        var bodySplit = splitPhrase(phraseBody.getText(), "PP");
        List<Phrase> phraseList = formatPhraseList(bodySplit);
        return formatBody(phraseList);
    }

    private String[] splitPhrase(String text, String pp) {
        var result = text.split(pp);
        return Arrays.copyOfRange(result, 1, result.length);
    }

    private PhraseBody formatBody(List<Phrase> phraseList) {
        StringBuilder formatBody = new StringBuilder();
        for (int i = 0; i < phraseList.size(); i++) {
            Phrase phrase = phraseList.get(i);
            String formatString = getFormat(phrase);
            formatBody.append(formatString);
        }
        return new PhraseBody(formatBody.toString().trim());
    }

    private String getFormat(Phrase phrase) {
        return String.format("%d %s$ %d %s& %s| ", phrase.getSrcTokensNumber(), phrase.getSrcTokens(),
                phrase.getTrgTokensNumber(), phrase.getTrgTokens(), phrase.getOtherInfo());
    }

    private List<Phrase> formatPhraseList(String[] bodySplit) {
        List<Phrase> result = new ArrayList<>();
        for (int i = 0; i < bodySplit.length; i++) {
            String[] phrases = getPhrases(bodySplit[i]);
            result.add(getPhrase(phrases));
        }
        return result;
    }

    private Phrase getPhrase(String[] phrases) {
        int srcTokensNumber = Integer.parseInt(phrases[1]);
        int trgTokensNumber = Integer.parseInt(phrases[2]);
        String srcToken, trgToken, otherInfo;
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < srcTokensNumber; j++) {
            stringBuilder.append(phrases[3 + j] + " ");
        }
        srcToken = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        for (int j = 0; j < trgTokensNumber; j++) {
            stringBuilder.append(phrases[4 + srcTokensNumber + j] + " ");
        }
        trgToken = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        for (int j = 5 + trgTokensNumber + srcTokensNumber; j < phrases.length; j++) {
            stringBuilder.append(phrases[j] + " ");
        }
        otherInfo = stringBuilder.toString();
        return new Phrase(srcTokensNumber, trgTokensNumber, srcToken, trgToken, otherInfo);
    }

    private String[] getPhrases(String s) {
        return s.split(" ");
    }
}
