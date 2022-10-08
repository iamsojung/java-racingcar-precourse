package racingcar.exception;

public class IllegalArgumentException extends RuntimeException{
    public static final String MSG_MAX_LENGTH_CAR_NAME = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    public static final String MSG_MIN_LENGTH_CAR_NAME = "[ERROR] 자동차 이름은 1자 이상이여야 합니다.";

    public IllegalArgumentException(final String errorMessage) {super(errorMessage);}
}
