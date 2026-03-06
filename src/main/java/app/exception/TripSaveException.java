package app.exception;

public class TripSaveException extends RuntimeException {
    public TripSaveException(String message) {
        super(message);
    }
}
