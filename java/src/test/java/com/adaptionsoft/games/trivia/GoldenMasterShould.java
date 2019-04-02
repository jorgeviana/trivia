package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;


import static org.junit.Assert.assertEquals;

public class GoldenMasterShould {
    public static final String OUTPUT_TEST = "test_output/test_output.txt";
    private PrintStream out;
    private PrintStream defaultOut;


    @Test
    public void run_game_1000_times() throws IOException {
        defaultOut = System.out;
        out = new PrintStream(new FileOutputStream(OUTPUT_TEST));
        System.setOut(out);

        for (int i = 0; i < 1000; i++) {
            Random random = new Random(i);
            new GameRunner(random).run();
        }

        out.flush();
        out.close();

        System.setOut(defaultOut);

        List<String> goldenMaster = Files.readAllLines(Paths.get("golden_master.txt"));
        List<String> testOutput = Files.readAllLines(Paths.get(OUTPUT_TEST));

        assertEquals(goldenMaster, testOutput);
    }
}
