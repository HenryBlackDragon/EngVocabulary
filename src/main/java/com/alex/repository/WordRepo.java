package com.alex.repository;

import com.alex.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepo extends JpaRepository<Word, Long> {
}
