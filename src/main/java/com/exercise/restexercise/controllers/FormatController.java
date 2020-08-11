package com.exercise.restexercise.controllers;

import com.exercise.restexercise.domain.PhraseBody;
import com.exercise.restexercise.services.MungingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/format")
public class FormatController {

    private final MungingService mungingService;

    public FormatController(MungingService mungingService) {
        this.mungingService = mungingService;
    }

    @PostMapping
    public PhraseBody formatBody(@RequestBody PhraseBody phraseBody) {
        return this.mungingService.format(phraseBody);
    }
}

