package com.exercise.restexercise.controllers;

import com.exercise.restexercise.domain.NGram;
import com.exercise.restexercise.domain.NGramBody;
import com.exercise.restexercise.services.NGramService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ngram")
public class NGramController {

    private final NGramService nGramService;

    public NGramController(NGramService nGramService) {
        this.nGramService = nGramService;
    }

    @PostMapping
    public List<NGram> getNGram(@RequestBody NGramBody nGramBody) {
        return nGramService.getNGrams(nGramBody);
    }
}
