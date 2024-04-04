package com.example.CoursePaper2.service;

import com.example.CoursePaper2.exception.QuestionsNotManu;
import com.example.CoursePaper2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    Random random;

    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.random = new Random();
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount){
        Set<Question> questions = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new QuestionsNotManu();
        }
        while (questions.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            questions.add(randomQuestion);
        }
        return questions;
    }
}
