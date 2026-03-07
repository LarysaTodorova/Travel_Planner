package app.exception;

public class TripNotFoundByTitleException extends RuntimeException {
    public TripNotFoundByTitleException(String message) {
        super(message);
    }
}
