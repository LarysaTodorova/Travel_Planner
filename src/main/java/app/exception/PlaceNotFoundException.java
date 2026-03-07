package app.exception;

public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException(Long id) {
        super(String.format("Place with Id %d does not exist", id));
    }
}
