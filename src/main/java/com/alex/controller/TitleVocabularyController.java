package com.alex.controller;

import com.alex.model.TitleVocabulary;
import com.alex.repository.TitleRepo;
import com.alex.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TitleVocabularyController {

    @Autowired
    private TitleRepo titleRepo;

    @GetMapping("/titles")
    public List<TitleVocabulary> getAllTitles() {
        return titleRepo.findAll();
    }

    @PostMapping("/title")
    public TitleVocabulary createVocabulary(@RequestBody TitleVocabulary vocabulary) {
        return titleRepo.save(Util.convert(vocabulary));
    }

    //TODO: PUT, DELETE
}
