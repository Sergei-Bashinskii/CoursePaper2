package com.example.CoursePaper2.service;

import com.example.CoursePaper2.exception.NullParametersException;
import com.example.CoursePaper2.helper.HelperNull;
import com.example.CoursePaper2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        if (HelperNull.nullString(question) || HelperNull.nullString(answer)) {
            throw new NullParametersException();
        }
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (HelperNull.nullQuestion(question)) {
            throw new NullParametersException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (HelperNull.nullQuestion(question)) {
            throw new NullParametersException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NullParametersException();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        return questions.stream()
                .skip(randomIndex)
                .findFirst()
                .orElse(null);
    }
}
