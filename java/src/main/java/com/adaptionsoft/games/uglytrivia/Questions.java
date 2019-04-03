package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {
    LinkedList<String> popQuestions = new LinkedList();
    LinkedList<String> scienceQuestions = new LinkedList();
    LinkedList<String> sportsQuestions = new LinkedList();
    LinkedList<String> rockQuestions = new LinkedList();


    void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    String askQuestionForCategory(String currentCategory) {
        if (currentCategory == "Pop") {
            return popQuestions.removeFirst();
        }
        if (currentCategory == "Science") {
            return scienceQuestions.removeFirst();
        }
        if (currentCategory == "Sports") {
            return sportsQuestions.removeFirst();
        }
        if (currentCategory == "Rock") {
            return rockQuestions.removeFirst();
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
