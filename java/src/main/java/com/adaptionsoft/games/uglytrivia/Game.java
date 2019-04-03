package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    public static final int MAXIMUM_PLACE = 12;

    List<Player> playersList = new ArrayList<>();

    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int indexOfCurrentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        createQuestions();
    }

    private void createQuestions() {
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

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean addPlayer(String playerName) {
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        playersList.add(new Player(playerName));

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + playersList.size());
        return true;
    }

    public int howManyPlayers() {
        return playersList.size();
    }

    public void roll(int roll) {
        printCurrentPlayer(roll);

        if (isCurrentPlayerInPenaltyBox() && !isEven(roll)) {
            setPlayerStaysInPenaltyBox();
            return;
        }

        if (isCurrentPlayerInPenaltyBox() && isEven(roll)) {
            setPlayerOutOfPenaltyBox();
        }

        movePlayer(roll);
        printCurrentCategory();
        askQuestion();
    }

    private boolean isEven(int roll) {
        return roll % 2 != 0;
    }

    private boolean isCurrentPlayerInPenaltyBox() {
        return inPenaltyBox[indexOfCurrentPlayer];
    }

    private void setPlayerStaysInPenaltyBox() {
        System.out.println(getCurrentPlayerName() + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
    }

    private void setPlayerOutOfPenaltyBox() {
        System.out.println(getCurrentPlayerName() + " is getting out of the penalty box");
        isGettingOutOfPenaltyBox = true;
    }

    private void printCurrentCategory() {
        System.out.println("The category is " + currentCategory());
    }

    private void printCurrentPlayer(int roll) {
        System.out.println(getCurrentPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);
    }

    private void movePlayer(int roll) {
        places[indexOfCurrentPlayer] = places[indexOfCurrentPlayer] + roll;
        if (places[indexOfCurrentPlayer] >= MAXIMUM_PLACE) places[indexOfCurrentPlayer] = places[indexOfCurrentPlayer] - MAXIMUM_PLACE;
        System.out.println(getCurrentPlayerName()
                + "'s new location is "
                + places[indexOfCurrentPlayer]);
    }

    private String getCurrentPlayerName() {
        return playersList.get(indexOfCurrentPlayer).getName();
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }


    private String currentCategory() {
        if (places[indexOfCurrentPlayer] == 0) return "Pop";
        if (places[indexOfCurrentPlayer] == 4) return "Pop";
        if (places[indexOfCurrentPlayer] == 8) return "Pop";
        if (places[indexOfCurrentPlayer] == 1) return "Science";
        if (places[indexOfCurrentPlayer] == 5) return "Science";
        if (places[indexOfCurrentPlayer] == 9) return "Science";
        if (places[indexOfCurrentPlayer] == 2) return "Sports";
        if (places[indexOfCurrentPlayer] == 6) return "Sports";
        if (places[indexOfCurrentPlayer] == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (isCurrentPlayerInPenaltyBox() && !isGettingOutOfPenaltyBox) {
            setNextPlayer();
            return true;
        }

        incrementPurse();

        boolean winner = didPlayerWin();
        setNextPlayer();

        return winner;
    }

    private void incrementPurse() {
        System.out.println("Answer was correct!!!!");
        purses[indexOfCurrentPlayer]++;
        System.out.println(getCurrentPlayerName()
                + " now has "
                + purses[indexOfCurrentPlayer]
                + " Gold Coins.");
    }

    private void setNextPlayer() {
        indexOfCurrentPlayer++;
        if (indexOfCurrentPlayer == playersList.size()) indexOfCurrentPlayer = 0;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayerName() + " was sent to the penalty box");
        inPenaltyBox[indexOfCurrentPlayer] = true;

        setNextPlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(purses[indexOfCurrentPlayer] == 6);
    }
}
