package com.exercise.restexercise.services;

import com.exercise.restexercise.domain.NGram;
import com.exercise.restexercise.domain.NGramBody;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NGramService {

    public NGramService() {
    }

    public List<NGram> getNGrams(NGramBody nGramBody) {
        return formatNGrams(nGramBody);
    }

    private List<NGram> formatNGrams(NGramBody nGramBody) {
        String[] splitNGram = nGramBody.getText().split(" ");
        Map<String, Integer> map = getMap(nGramBody, splitNGram);
        List<NGram> nGrams = getNGramsFromMap(map);
        return sortNGrams(nGrams);
    }

    private List<NGram> sortNGrams(List<NGram> nGrams) {
        Collections.sort(nGrams, (o1, o2) -> o1.getNumberOfWords() == o2.getNumberOfWords() ?
                Integer.compare(o1.getCount(), o2.getCount()) :
                Integer.compare(o1.getNgram().length(), o2.getNgram().length()));
        Collections.reverse(nGrams);
        return nGrams;
    }

    private List<NGram> getNGramsFromMap(Map<String, Integer> map) {
        List<NGram> nGrams = new ArrayList<>();
        map.entrySet().stream().
                forEach(k -> nGrams.add(new NGram(k.getKey(), k.getValue(), k.getKey().split(",").length)));
        return nGrams;
    }

    private Map<String, Integer> getMap(NGramBody nGramBody, String[] splitNGram) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = nGramBody.getMaxNGramCount(); i > 0; i--) {
            for (int j = 0; j < splitNGram.length - i + 1; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Arrays.toString(Arrays.copyOfRange(splitNGram, j, j + i)));
                map.putIfAbsent(stringBuilder.toString(), 0);
                map.put(stringBuilder.toString(), map.get(stringBuilder.toString()) + 1);
            }
        }
        return map;
    }
}
