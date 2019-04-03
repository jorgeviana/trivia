package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int MAXIMUM_PLACE = 12;

    Questions questions = new Questions();
    List<Player> playersList = new ArrayList<>();

    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];


    int indexOfCurrentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        questions.fillQuestions();
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
        String currentCategory = currentCategory();
        Object question = questions.askQuestionForCategory(currentCategory);
        System.out.println(question);
    }


    private String currentCategory() {
        int currentPlace = places[indexOfCurrentPlayer];
        return questions.getCategoryForPlace(currentPlace);
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
