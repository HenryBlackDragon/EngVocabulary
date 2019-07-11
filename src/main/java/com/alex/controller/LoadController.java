package com.alex.controller;

import com.alex.model.Word;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("test")
public class LoadController {

    @GetMapping
    public List<Word> response() {
        return Arrays.asList(new Word(1L, "Hello", "Привет"), new Word(2L,"Bye", "Пока"));
    }

}
