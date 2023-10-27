package baseball.constant;

public enum PlayerInput {
    START("1"),
    EXIT("2");

    private final String num;

    PlayerInput(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }
}
