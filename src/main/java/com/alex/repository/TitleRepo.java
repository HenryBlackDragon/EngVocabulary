package com.alex.repository;

import com.alex.model.TitleVocabulary;
import com.alex.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepo extends JpaRepository<TitleVocabulary, Long> {

    TitleVocabulary findByTitle(String name);
}
