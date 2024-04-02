package com.example.CoursePaper2.service;

import com.example.CoursePaper2.model.Question;

import java.util.*;

public class JavaQuestionService implements QuestionService{

    private List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question("Кто впервые подковал блоху?", "Левша"),
            new Question("Что все дырявое, но держит воду?", "Губка"),
            new Question("Что можно услышать, но нельзя увидеть?", "Песню"),
            new Question("Рыцарь Печального Образа?", "Дон Кихот"),
            new Question("Модель земного шара?", "Глобус")
    ));
    private final Integer numberQuestions = 10;

    public Question add(String question, String answer) {
        return null;
    }

    public Question add(Question question) {
        return null;
    }

    public Question remove(Question question) {
        return null;
    }

    public Collection<Question> getAll() {
        return null;
    }

    public Question getRandomQuestion() {
        return null;
    }

    public int getRandomQuestion(Integer numberQuestions) {
        Random numbersRandom = new Random();
        return numbersRandom.nextInt(numberQuestions) + 1;
    }

    public static void main(String[] args) {
        int x = 10;
        Random y = new Random();
        int z = y.nextInt(x) + 1;
        System.out.println("z = " + z);
    }
}
