package com.demo.quizapp.dao;

import com.demo.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByLanguage(String language);

    @Query(value = "SELECT * FROM question q WHERE q.language=:language ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByLanguage(String language, int numQ);
}
