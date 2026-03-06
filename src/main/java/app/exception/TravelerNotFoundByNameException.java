package app.exception;

public class TravelerNotFoundByNameException extends RuntimeException {
    public TravelerNotFoundByNameException(String message) {
        super(message);
    }
}
