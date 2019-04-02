
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;
	private final Random random;

	public GameRunner(Random random) {
		this.random = random;
	}

	public static void main(String[] args) {
		new GameRunner(new Random()).run();
	}

	public void run() {
		Game aGame = new Game();

		aGame.addPlayer("Chet");
		aGame.addPlayer("Pat");
		aGame.addPlayer("Sue");

		do {

			aGame.roll(random.nextInt(5) + 1);

			if (random.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}



		} while (notAWinner);
	}
}
