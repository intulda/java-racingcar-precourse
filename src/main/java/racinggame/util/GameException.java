package racinggame.util;

/**
 * 해당 게임만의 예외를 담아주는 클래스
 */
public class GameException extends IllegalArgumentException {

    public GameException(String message) {
        super(message);
    }
}
