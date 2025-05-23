public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty() { super(); }
    public ExceptionIsEmpty(String message) { super(message); }
}
/////////////////////////////////////////////////////////////////////////////////////

public class ItemDuplicated extends Exception {
    public ItemDuplicated() { super(); }
    public ItemDuplicated(String message) { super(message); }
}
/////////////////////////////////////////////////////////////////////////////////////

public class ItemNotFound extends Exception {
    public ItemNotFound() { super(); }
    public ItemNotFound(String message) { super(message); }
}
