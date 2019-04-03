package com.adaptionsoft.games.uglytrivia;

import java.util.*;

public class Questions {
    List<Category> categories = Arrays.asList(
            new Category("Pop"),
            new Category("Science"),
            new Category("Sports"),
            new Category("Rock"));

    void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            for (Category category : categories) {
                category.addQuestion(category.getName() +" Question " + i);
            }
        }
    }

    String askQuestionForCategory(String currentCategory) {
        Optional<Category> category = categories
                .stream()
                .filter(c -> currentCategory.equals(c.getName()))
                .findFirst();
        if (!category.isPresent()) return null;
        return category.get().getNextQuestion();
    }

    String getCategoryForPlace(int currentPlace) {
        if (currentPlace == 0) return "Pop";
        if (currentPlace == 4) return "Pop";
        if (currentPlace == 8) return "Pop";
        if (currentPlace == 1) return "Science";
        if (currentPlace == 5) return "Science";
        if (currentPlace == 9) return "Science";
        if (currentPlace == 2) return "Sports";
        if (currentPlace == 6) return "Sports";
        if (currentPlace == 10) return "Sports";
        return "Rock";
    }

    private String createRockQuestion(int index) {
        return "Rock Question " + index;
    }
}
