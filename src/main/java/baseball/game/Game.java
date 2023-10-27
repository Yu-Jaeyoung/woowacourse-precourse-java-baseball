package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final GamePlayerInput gamePlayerInput = new GamePlayerInput();

    public void run() {

        boolean restart = true;

        System.out.println(GamePhrases.start);

        do {
            baseBallGameRunner();
            switch (gamePlayerInput.userRestartInput()) {
                case "1" -> {
                }
                case "2" -> {
                    Console.close();
                    restart = false;
                }
            }
        } while (restart);
    }

    private void baseBallGameRunner() {

        boolean continueBaseballGame;

        GameReferee gameReferee = new GameReferee();
        gameReferee.makeAnswer();

        do {
            System.out.print(GamePhrases.inputNum);

            gameReferee.countStrikeAndBall(gamePlayerInput.userAnswerInput());

            continueBaseballGame = gameReferee.continueBaseballGame();
        } while (continueBaseballGame);
    }
}
