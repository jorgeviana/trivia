package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class GoldenMaster {

    private PrintStream out;
    private PrintStream defaultOut;

    @Before
    public void setUp() throws Exception {
        defaultOut = System.out;
        out = new PrintStream(new FileOutputStream("golden_master.txt"));
        System.setOut(out);
    }

    @After
    public void tearDown() throws Exception {
        out.flush();
        out.close();

        System.setOut(defaultOut);
    }

    @Test
    public void run_game_1000_times() throws FileNotFoundException {
        Random random = new Random(41);
        new GameRunner(random).run();

    }
}
