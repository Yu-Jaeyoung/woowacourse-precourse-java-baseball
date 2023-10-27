package baseball.game;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameReferee {
    private final List<Integer> answer = new ArrayList<>();

    private int strike = 0;

    private int ball = 0;

    private void clearStrikeAndBall() {
        this.strike = 0;
        this.ball = 0;
    }

    protected void countStrikeAndBall(final List<Integer> userInput) {
        if (userInput.equals(answer)) {
            this.strike = this.answer.size();

            return;
        }

        for (int i = 0; i < userInput.size(); i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                this.strike++;
            } else if (answer.contains(userInput.get(i))) {
                this.ball++;
            }
        }
    }

    protected boolean continueBaseballGame() {
        if (this.strike == Constant.ANSWER_LENGTH) {
            GamePhrasePrinter.strike(strike);
            System.out.println(GamePhrases.answer + "\n" + GamePhrases.end);

            return false;
        }

        if (strike != 0 && ball != 0) {
            GamePhrasePrinter.ballAndStrike(strike, ball);
            clearStrikeAndBall();

            return true;
        }

        if (strike > 0) {
            GamePhrasePrinter.strike(strike);
            clearStrikeAndBall();

            return true;
        }

        if (ball > 0) {
            GamePhrasePrinter.ball(ball);

            clearStrikeAndBall();

            return true;
        }

        System.out.println(GamePhrases.out);
        clearStrikeAndBall();

        return true;
    }

    protected void makeAnswer() {
        while (this.answer.size() < Constant.ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }
}
