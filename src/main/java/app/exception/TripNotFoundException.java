package app.exception;

public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException(Long id) {
        super(String.format("Trip with id %d not found", id));
    }
}
