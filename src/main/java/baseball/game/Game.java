package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final GamePlayer gamePlayer = new GamePlayer();

    public void run() {

        boolean restart = true;

        System.out.println(GamePhrases.start);

        do {
            baseBallGameRunner();
            switch (gamePlayer.userRestartInput()) {
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

            gameReferee.countStrikeAndBall(gamePlayer.userAnswerInput());

            continueBaseballGame = gameReferee.continueBaseballGame();
        } while (continueBaseballGame);
    }
}
