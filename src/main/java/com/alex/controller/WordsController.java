package com.alex.controller;

import com.alex.exception.ResourceNotFoundException;
import com.alex.model.Word;
import com.alex.repository.TitleRepo;
import com.alex.repository.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordsController {

    @Autowired
    private WordRepo wordRepo;

    @Autowired
    private TitleRepo titleRepo;

    @GetMapping(path = "/title/{name}/words")
    public List<Word> getAllWordsByTitleName(@PathVariable String name) {
        return wordRepo.findAllByTitleName(titleRepo.findByTitle(name.toLowerCase())
                .orElseThrow(() -> new ResourceNotFoundException("Title vocabulary with name:" + name + " not found")));
    }

    @PostMapping(path = "/title/{name}/word/add")
    public Word post(@PathVariable String name, @RequestBody Word word) {
        return titleRepo.findByTitle(name.toLowerCase()).map(title -> {
            word.setTitleName(title);
            return wordRepo.save(word);
        }).orElseThrow(() -> new ResourceNotFoundException("Title vocabulary with name:" + name + " not found"));

    }
}
