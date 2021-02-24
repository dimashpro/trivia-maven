package com.tekwill.java.fundamentals.trivia.domain;




import com.tekwill.java.fundamentals.trivia.domain.exceptions.EmptyQuestionTextException;
import com.tekwill.java.fundamentals.trivia.domain.exceptions.InvalidLevelException;
import com.tekwill.java.fundamentals.trivia.domain.exceptions.InvalidScoreException;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Data
public class Question {
    private Long id;
    private List<Answer> answers = new ArrayList<>();
    private int score;
    private int level;
    private String text;

    public Question(Long id, List<Answer> answers, int score, int level, String text) {
        this(score, level, text, answers);
        this.id = id;
    }

    public Question(Long id, int score, int level, String text) {
        this(score, level, text);
        this.id = id;
    }

    public Question(int score, int level, String text, List<Answer> answers) {
        this(score, level, text);
        this.answers = answers;
        this.answers.forEach(a -> a.setQuestion(this));
    }

    public Question(Long id, int score, int level, String text, List<Answer> answers) {
        this(score, level, text);
        this.id = id;
        this.answers = answers;
        this.answers.forEach(a -> a.setQuestion(this));
    }

    public Question(int score, int level, String text) {
        if (text.isEmpty()) {
            throw new EmptyQuestionTextException("Question text should not be empty");
        }
        if (score < 0) {
            throw new InvalidScoreException("Score must be greater than 0");
        }
        if (level < 0) {
            throw new InvalidLevelException("Level must be greater than 0");
        }
        this.score = score;
        this.level = level;
        this.text = text;
    }

    public Answer getCorrectAnswer() {
        for (Answer answer : answers) {
            if (answer.isCorrect())
                return answer;
        }
        return null;
    }

    public List<Answer> getWrongAnswers() {
        List<Answer> wrongAnswers = new ArrayList<>();
        for (Answer answer : answers) {
            if (!answer.isCorrect()) {
                wrongAnswers.add(answer);
            }
        }
        Collections.shuffle(wrongAnswers);
        return wrongAnswers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }

    public void removeAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(null);
    }
}
