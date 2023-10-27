package baseball.game;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GamePlayer {

    protected List<Integer> userAnswerInput() {

        String[] userInputToStringArray;

        List<Integer> userInputToArrayListInteger = new ArrayList<>();

        try {
            userInputToStringArray = Validator
                    .validator(Console.readLine())
                    .split("");
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }

        for (String string : userInputToStringArray) {
            userInputToArrayListInteger.add(Integer.parseInt(string));
        }

        return userInputToArrayListInteger;
    }

    protected String userRestartInput() {

        String userRestartInput;

        try {
            userRestartInput = Validator
                    .userElseInputAfterEndPhraseException(Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }

        return userRestartInput;
    }
}
