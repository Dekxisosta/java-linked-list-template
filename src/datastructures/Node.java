package datastructures;

/* ==========================================
 *  NODE CLASS
 ============================================*/
/**
 * Node object for linked lists
 */
public class Node {
    /* ==========================================
     *  INSTANCE FIELDS / CLASS ATTRIBUTES
     ============================================*/
    /** Data inside the linked list */
    private int data;

    /** For mapping node location */
    private Node next;

    /* ==========================================
     *  EXPOSED API / ACCESSORS AND MUTATORS
     ============================================*/
    /** @return next node's memory address of the current node */
    public Node getNext() {return next;}

    /** @return data of the node */
    public int  getData() {return data;}

    /** @param next memory address next to the node */
    public void setNext(Node next) {this.next = next;}

    /** @param data to be set for the node */
    public void setData(int data) {this.data = data;}

    /* ==========================================
     *  EXPOSED API / PRINT UTILITY
     ============================================*/
    /**
     * @return formatted string with details such as
     * current address, data, and next node's address
     */
    @Override
    public String toString() {
        return String.format(
                "\nNode hash code @%s\nNode data=%s\nNode next hash code=%s",
                Integer.toHexString(System.identityHashCode(this)),
                data,
                (next == null ? "null" : "Node@" + Integer.toHexString(System.identityHashCode(next)))
        );
    }
}
