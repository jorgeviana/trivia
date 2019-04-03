package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {
    LinkedList<String> scienceQuestions = new LinkedList();
    LinkedList<String> sportsQuestions = new LinkedList();
    LinkedList<String> rockQuestions = new LinkedList();

    Category pop = new Category("Pop");
    Category science = new Category("Science");
    Category sports = new Category("Sports");
    Category rock = new Category("Rock");

    void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            pop.addQuestion("Pop Question " + i);
            science.addQuestion("Science Question " + i);
            sports.addQuestion("Sports Question " + i);
            rock.addQuestion("Rock Question " + i);
        }
    }

    String askQuestionForCategory(String currentCategory) {
        if (currentCategory == "Pop") {
            return pop.getNextQuestion();
        }
        if (currentCategory == "Science") {
            return science.getNextQuestion();
        }
        if (currentCategory == "Sports") {
            return sports.getNextQuestion();
        }
        if (currentCategory == "Rock") {
            return rock.getNextQuestion();
        }
        return null;
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
