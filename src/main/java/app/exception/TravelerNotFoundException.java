package app.exception;

public class TravelerNotFoundException extends RuntimeException {
    public TravelerNotFoundException(Long id) {
        super(String.format("Traveler with id %s not found", id));
    }
}
