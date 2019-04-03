package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Category {
    private String name;
    private LinkedList<String> questions = new LinkedList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public String getNextQuestion() {
        return questions.removeFirst();
    }
}
