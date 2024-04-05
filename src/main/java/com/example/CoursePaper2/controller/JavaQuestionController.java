package com.example.CoursePaper2.controller;

import com.example.CoursePaper2.exception.IdenticalParametersException;
import com.example.CoursePaper2.exception.NullParametersException;
import com.example.CoursePaper2.model.Question;
import com.example.CoursePaper2.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController{

    QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @ExceptionHandler(NullParametersException.class)
    public ResponseEntity<String> messageNullPointerException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Нет входных параметров.");
    }

    @ExceptionHandler(IdenticalParametersException.class)
    public ResponseEntity<String> messageNullParametersException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Идентичные параметры.");
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question removequestion = new Question(question, answer);
        return service.remove(removequestion);
    }
}