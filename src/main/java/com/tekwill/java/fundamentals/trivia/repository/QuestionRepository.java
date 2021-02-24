package com.tekwill.java.fundamentals.trivia.repository;

import com.tekwill.java.fundamentals.trivia.domain.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> findQuestionsByLevel(int level);

    boolean save(Question question);

    boolean delete(Question question);

    List<Question> findAll();
}
