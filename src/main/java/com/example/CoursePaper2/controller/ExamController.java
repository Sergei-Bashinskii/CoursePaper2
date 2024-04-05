package com.example.CoursePaper2.controller;

import com.example.CoursePaper2.exception.QuestionsNotManu;
import com.example.CoursePaper2.model.Question;
import com.example.CoursePaper2.service.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {

    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @ExceptionHandler(QuestionsNotManu.class)
    public ResponseEntity<String> messageQuestionsNotManu() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Введенное количество вопросов не соответствует списку вопросов.");
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}