package com.alex.repository;

import com.alex.model.TitleVocabulary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitleRepo extends JpaRepository<TitleVocabulary, Long> {
    Optional<TitleVocabulary> findByTitle(String name);
}
