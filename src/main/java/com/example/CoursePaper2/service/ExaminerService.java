package com.example.CoursePaper2.service;

import com.example.CoursePaper2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}