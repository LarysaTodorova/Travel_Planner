package app.exception;

public class PlaceNotFoundByNameException extends RuntimeException {
    public PlaceNotFoundByNameException(String name) {
        super(String.format("Place with name %s not found", name));
    }
}
