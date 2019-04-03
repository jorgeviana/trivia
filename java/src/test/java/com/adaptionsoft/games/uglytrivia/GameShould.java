package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameShould {

    @Test
    public void add_player() {
        Game game = new Game();

        game.addPlayer("player1");
        game.addPlayer("player2");

        assertEquals(2, game.howManyPlayers());
    }

}