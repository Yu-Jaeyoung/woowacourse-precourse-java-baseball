package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Integer> answer = new ArrayList<>();

    private int strike = 0;

    private int ball = 0;

    public GameController() {
        while (this.answer.size() < AnswerLength.ANSWER_LENGTH.getAnswerLength()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }

    private void clearStrikeAndBall() {
        this.strike = 0;
        this.ball = 0;
    }

    protected void isStrikeOrBall(List<Integer> userInput) {
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

    protected boolean printResultPhrase() {
        if (this.strike == this.answer.size()) {
            GamePhrasePrinter.strike(strike);
            System.out.println(GamePhrases.answer);
            System.out.println(GamePhrases.end);

            return false;
        } else if ((strike + ball) == 0) {
            System.out.println(GamePhrases.out);
        } else if (strike != 0 && ball != 0) {
            GamePhrasePrinter.ballAndStrike(strike, ball);
            clearStrikeAndBall();
        } else if (strike > 0) {
            GamePhrasePrinter.strike(strike);
            clearStrikeAndBall();
        } else if (ball > 0) {
            GamePhrasePrinter.ball(ball);
            clearStrikeAndBall();
        }

        return true;
    }
}
