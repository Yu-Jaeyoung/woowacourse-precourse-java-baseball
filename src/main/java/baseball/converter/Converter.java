package baseball.converter;

import baseball.constant.PlayerInput;

public final class Converter {
    public static PlayerInput playerInputConverter(final String playerInput) {
        switch (playerInput) {
            case "1" -> {
                return PlayerInput.START;
            }
            case "2" -> {
                return PlayerInput.EXIT;
            }
        }

        return PlayerInput.EXIT;
    }
}
