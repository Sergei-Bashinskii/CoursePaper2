package com.example.CoursePaper2.service;

import com.example.CoursePaper2.exception.QuestionsNotManu;
import com.example.CoursePaper2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExaminerServiceImplTest {

    @Mock
    private QuestionService mockQuestionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(mockQuestionService);
    }

    @Test
    public void getQuestionsSuccess() {
        Set<Question> mockQuestions = new HashSet<>();
        mockQuestions.add(new Question("TestQuestion1", "TestAnswer1"));
        mockQuestions.add(new Question("TestQuestion2", "TestAnswer2"));
        mockQuestions.add(new Question("TestQuestion3", "TestAnswer3"));
        when(mockQuestionService.getAll()).thenReturn(mockQuestions);
        when(mockQuestionService.getRandomQuestion()).thenReturn(
                new Question("RandomQuestion1", "RandomAnswer1"),
                new Question("RandomQuestion2", "RandomAnswer2"),
                new Question("RandomQuestion3", "RandomAnswer3")
        );
        Collection<Question> resultQuestions = examinerService.getQuestions(3);
        assertNotNull(resultQuestions);
        assertEquals(3, resultQuestions.size());
    }

    @Test
    public void testGetQuestionsQuestionsNotManuException() {
        Set<Question> mockQuestions = new HashSet<>();
        mockQuestions.add(new Question("TestQuestion1", "TestAnswer1"));
        mockQuestions.add(new Question("TestQuestion2", "TestAnswer2"));
        when(mockQuestionService.getAll()).thenReturn(mockQuestions);
        assertThrows(QuestionsNotManu.class, () -> {
            examinerService.getQuestions(3);});
    }
}