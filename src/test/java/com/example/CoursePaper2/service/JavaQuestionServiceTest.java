package com.example.CoursePaper2.service;

import com.example.CoursePaper2.exception.IdenticalParametersException;
import com.example.CoursePaper2.exception.NullParametersException;
import com.example.CoursePaper2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JavaQuestionServiceTest {

    @Mock
    Question mockQuestion;

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void addStringQuestionSuccess() {
        String question = "TestQuestion";
        String answer = "TestAnswer";
        Question expectedQuestion = new Question(question,answer);
        assertNotNull(expectedQuestion);
        Question actualQuestion = javaQuestionService.add(question, answer);
        assertNotNull(actualQuestion);
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void exceptionAddNull() {
        assertThrows(NullParametersException.class, () -> {
            javaQuestionService.add(null, "TestAnswer");});
        assertThrows(NullParametersException.class, () -> {
            javaQuestionService.add("TestQuestion", null);});
        assertThrows(NullParametersException.class, () -> {
            javaQuestionService.add(null, null);});
    }

    @Test
    void exceptionAddIdenticalParameters() {
        assertThrows(IdenticalParametersException.class, () -> {
            javaQuestionService.add("TestQuestion", "TestQuestion");});
        assertThrows(IdenticalParametersException.class, () -> {
            javaQuestionService.add("TestAnswer", "TestAnswer");});
    }

    @Test
    void exceptionAddIdenticalQuestion() {
        Set<Question> questions = new HashSet<>();
        questions.add(mockQuestion);
        when(mockQuestion.getQuestion()).thenReturn("TestQuestion");
        when(mockQuestion.getAnswer()).thenReturn("TestAnswer");
        javaQuestionService.add("TestQuestion", "TestAnswer");
        assertThrows(IdenticalParametersException.class, () -> {javaQuestionService.add("TestQuestion", "TestAnswer");});
    }

    @Test
    void addQuestionSuccess() {
        Set<Question> questions = new HashSet<>();
        when(mockQuestion.getQuestion()).thenReturn("TestQuestion");
        when(mockQuestion.getAnswer()).thenReturn("TestAnswer");
        Question addedQuestion = javaQuestionService.add(mockQuestion);
        assertNotNull(addedQuestion);
        assertEquals("TestQuestion", addedQuestion.getQuestion());
        assertEquals("TestAnswer", addedQuestion.getAnswer());
    }

    @Test
    void exceptionAddQuestionNull() {
        assertThrows(NullParametersException.class, () -> {javaQuestionService.add(null);});
        when(mockQuestion.getQuestion()).thenReturn("TestQuestion");
        when(mockQuestion.getAnswer()).thenReturn("TestAnswer");
        assertDoesNotThrow(() -> {javaQuestionService.add(mockQuestion);});
    }

    @Test
    void removeQuestionSuccess() {
        when(mockQuestion.getQuestion()).thenReturn("TestQuestion");
        when(mockQuestion.getAnswer()).thenReturn("TestAnswer");
        javaQuestionService.add(mockQuestion);
        assertDoesNotThrow(() -> {
            javaQuestionService.remove(mockQuestion);});
    }

    @Test
    void exceptionRemoveNull() {
        assertThrows(NullParametersException.class, () -> {
            javaQuestionService.remove(null);});
        when(mockQuestion.getQuestion()).thenReturn("TestQuestion");
        when(mockQuestion.getAnswer()).thenReturn("TestAnswer");
        assertDoesNotThrow(() -> {
            javaQuestionService.add(mockQuestion);
            javaQuestionService.remove(mockQuestion);});
    }

    @Test
    void getAllSuccess() {
        Collection<Question> allQuestions = javaQuestionService.getAll();
        assertNotNull(allQuestions);
        assertEquals(0, allQuestions.size());
        when(mockQuestion.getQuestion()).thenReturn("TestQuestion");
        when(mockQuestion.getAnswer()).thenReturn("TestAnswer");
        javaQuestionService.add(mockQuestion);
        allQuestions = javaQuestionService.getAll();
        assertNotNull(allQuestions);
        assertEquals(1, allQuestions.size());
    }
}
