package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;
import java.util.List;

public class Category {
    private String name;
    private List<Integer> places;
    private LinkedList<String> questions = new LinkedList<>();

    public Category(String name, List<Integer> places) {
        this.name = name;
        this.places = places;
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public String getNextQuestion() {
        return questions.removeFirst();
    }

    public String getName() {
        return name;
    }

    public boolean isForPlace(int currentPlace) {
        return places.contains(currentPlace);
    }
}
