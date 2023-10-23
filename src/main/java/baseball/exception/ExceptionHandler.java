package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class ExceptionHandler {

    public String exceptionHandler(String userInput) {
        userElseInputException(userInput);
        userWrongLengthInputException(userInput);
        userDuplicatedInputException(userInput);
        userZeroInputException(userInput);

        return userInput;
    }

    private void userElseInputException(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception exception) {
            throw new IllegalArgumentException("");
        }
    }

    private void userWrongLengthInputException(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("");
        }
    }

    private void userDuplicatedInputException(String userInput) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            set.add(userInput.charAt(i));
        }

        if (set.size() != 3) {
            throw new IllegalArgumentException("");
        }
    }

    private void userZeroInputException(String userInput) {
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(String.valueOf(userInput.charAt(i))) == 0) {
                throw new IllegalArgumentException("");
            }
        }
    }

    public String userElseInputAfterEndPhraseException(String userInput) {

        if (userInput.equals("1") || userInput.equals("2")) {
            return userInput;
        }

        throw new IllegalArgumentException();
    }
}