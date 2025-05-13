package exceptions;

public class ItemNoEncontrado extends RuntimeException {
    public ItemNotFound(String message) {
        super(message);
    }
}
