package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();


    void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    void askQuestionForCategory(String currentCategory) {
        if (currentCategory == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory == "Rock")
            System.out.println(rockQuestions.removeFirst());
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
}
