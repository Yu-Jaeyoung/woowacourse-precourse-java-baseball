package baseball.game;

public final class GamePhrasePrinter {
    public static void strike(final int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void ball(final int ball) {
        System.out.println(ball + "볼");
    }

    public static void ballAndStrike(final int strike, final int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
