package com.example.CoursePaper2.helper;

import com.example.CoursePaper2.model.Question;

public class HelperNull {

    public static boolean nullString(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean nullQuestion(Question string) {
        return string == null;
    }
}