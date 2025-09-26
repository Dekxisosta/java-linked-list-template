package datastructures;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super("Linked list is empty");
    }
}
