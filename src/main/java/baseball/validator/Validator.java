package baseball.validator;

import baseball.constant.Constant;
import java.util.HashSet;
import java.util.Set;

public final class Validator {

    public static String validator(final String userInput) {
        elseInput(userInput);
        wrongLengthInput(userInput);
        duplicatedInput(userInput);
        zeroInput(userInput);

        return userInput;
    }

    private static void elseInput(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception exception) {
            throw new IllegalArgumentException("숫자 외 입력 예외");
        }
    }

    private static void wrongLengthInput(final String userInput) {
        if (userInput.length() != Constant.ANSWER_LENGTH) {
            throw new IllegalArgumentException("입력 길이 예외");
        }
    }

    private static void duplicatedInput(final String userInput) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < Constant.ANSWER_LENGTH; i++) {
            set.add(userInput.charAt(i));
        }

        if (set.size() != Constant.ANSWER_LENGTH) {
            throw new IllegalArgumentException("중복된 입력 예외");
        }
    }

    private static void zeroInput(final String userInput) {
        for (int i = 0; i < Constant.ANSWER_LENGTH; i++) {
            if (Integer.parseInt(String.valueOf(userInput.charAt(i))) == 0) {
                throw new IllegalArgumentException("`0` 입력 예외");
            }
        }
    }

    public static String userElseInputAfterEndPhraseException(final String userInput) {

        if (userInput.equals("1") || userInput.equals("2")) {
            return userInput;
        }

        throw new IllegalArgumentException("1, 2 이외 입력 예외");
    }
}
