package com.alex.controller;

import com.alex.model.Word;
import com.alex.repository.TitleRepo;
import com.alex.repository.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class LoadController {

    @Autowired
    private WordRepo wordRepo;

    @Autowired
    private TitleRepo titleRepo;

    @GetMapping(path = "/get/{name}")
    public List<Word> get(@PathVariable String name) {
//        return wordRepo.findAll();

        Long id = titleRepo.findByTitle(name).getId();

        return wordRepo.findAllByTitleName(titleRepo.findByTitle(name));
    }

    @PostMapping(path = "/add")
    public String post(@RequestBody Word word) {
        wordRepo.save(word);
        return "Saved";
    }
}
