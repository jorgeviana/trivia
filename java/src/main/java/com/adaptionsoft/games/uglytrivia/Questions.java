package com.adaptionsoft.games.uglytrivia;

import java.util.*;

import static java.util.Arrays.asList;

public class Questions {
    List<Category> categories = asList(
            new Category("Pop", asList(0, 4, 8)),
            new Category("Science", asList(1, 5, 9)),
            new Category("Sports", asList(2, 6, 10)),
            new Category("Rock", asList(3, 7, 11)));

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
        Optional<Category> category = categories
                .stream()
                .filter(c -> c.isForPlace(currentPlace))
                .findFirst();

        if (!category.isPresent()) return "Rock";

        return category.get().getName();
    }
}
