package datastructures;
/* ==========================================
 *  LINKED LIST CLASS
 ============================================*/

import ui.*;

/**
 * Singly linked list structure. More scalable than an array
 * <br>
 * <b>DEPENDENCIES</b>
 * <ul>
 *     <li>{@link Node} Node object</li>
 * </ul>
 */
public class LinkedList {
    /* ==========================================
     *  INSTANCE FIELDS / CLASS ATTRIBUTES
     ============================================*/
    /** Holder for the first node of the linked list */
    private Node head;

    /** Holder for the last node of the linked list */
    private Node tail;

    /** Holder for the last node of the linked list */
    private int size;

    /* ==========================================
     *  EXPOSED API / ACCESSORS
     ============================================*/
    /** @return the size of the list */
    public int size(){
        return size;
    }

    /** @return true if list is empty */
    public boolean isEmpty(){
        return head == null;
    }

    /** @return true if node has one element */
    public boolean isSingleNode(){
        return !isEmpty() && head == tail;
    }

    /** @return data inside head */
    public int getFirst() throws EmptyListException{
        if (isEmpty())
            throw new EmptyListException();
        return head.getData();
    }

    /** @return data inside tail */
    public int getLast() throws EmptyListException{
        if(isEmpty())
            throw new EmptyListException();
        return tail.getData();
    }

    /**
     * Gets the value of the node at the specified index
     * <p></p>
     * @param index the location of the node
     * @return data of the specified index
     */
    public int getAtIndex(int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        return getNodeAtIndex(index).getData();
    }
    /* ==========================================
     *  EXPOSED API / MUTATORS
     ============================================*/

    /** Clears all nodes of the list */
    public void clear(){
        head = null;
        tail = null;
        size=0;
    }

    /**
     * Adds a node after the tail of the linked list
     * @param data data to be added to the new node
     */
    public void addFirst(int data){
        Node newNode = new Node();
        newNode.setData(data);

        if (isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds a node after the tail of the linked list
     * @param data data to be added to the new node
     */
    public void addLast(int data){
        Node newNode = new Node();
        newNode.setData(data);

        if(this.isEmpty())
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;

        size++;
    }

    /**
     * Sets the data of a specified node
     * @param data data to be changed for the specified node
     * @param index the location of the new node
     * @throws IndexOutOfBoundsException
     */
    public void setAtIndex(int data, int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        getNodeAtIndex(index).setData(data);
    }

    /**
     * Adds a node at the specified index
     * @param data data of the new node
     * @param index the location of the new node
     * @throws IndexOutOfBoundsException
     */
    public void insertAtIndex(int data, int index) throws IndexOutOfBoundsException{
        checkIndexForInsert(index);

        if (index == 0){
            addFirst(data);
            return;
        }

        if (index == size){
            addLast(data);
            return;
        }

        // Creates a new node
        Node newNode = new Node();
        newNode.setData(data);

        // Inserts new node in the location of the original node at the specified index
        Node prevNode = getNodeAtIndex(index-1);
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);

        size++;
    }

    /** Removes the first node in the linked list */
    public void removeFirst(){
        if(isEmpty())
            return;

        if (isSingleNode()) {
            head = null;
            tail = null;
        }else
            head = head.getNext();

        size--;
    }

    /** Removes the last node in the linked list */
    public void removeLast(){
        if(isEmpty())
            return;

        ConsolePrinter printer = new ConsolePrinter();

        if(isSingleNode()){
            head = null;
            tail = null;
        }else{
            System.out.printf("TITE");
            tail = getNodeAtIndex(size-2);
            tail.setNext(null);
        }

        size--;
    }

    /**
     * Removes a node from the specified index
     * @param index
     */
    public void removeAtIndex(int index) throws IndexOutOfBoundsException{
        checkIndex(index);

        if (index == 0){
            removeFirst();
            return;
        }

        if (index == size-1){
            removeLast();
            return;
        }

        // Links prev node and next node of the node at the specified index
        Node prev = getNodeAtIndex(index-1);
        prev.setNext(prev.getNext().getNext());
    }
    /* ==========================================
     *  EXPOSED API / QUERY
     ============================================*/
    /**
     * Searches if data exists in the list, returns index of the first occurrence
     * @param data data to be searched
     */
    public int indexOf(int data){
        if(isEmpty())
            return -1;

        int counter = 0;
        Node current = head;

        // Checks if value exists on the list, returns the index
        while(current != null){
            if(current.getData() == data)
                return counter;
            current = current.getNext();
            counter++;
        }

        return -1;
    }
    /**
     * Returns a list of all indices where `data` occurs in the linked list.
     * If the value does not exist, returns an empty list.
     */
    public int[] indicesOf(int data) {
        // Temporary container for indices
        int[] temp = new int[size];

        // Holds the size of the integer array
        int counter = 0;

        // Checks for indices that match data
        Node current = head;
        for(int i = 0; i < size; i++){
            if(current.getData() == data)
                temp[counter++] = i;

            current = current.getNext();
        }

        // Creates a fixed container with the indices earlier
        int[] indices = new int[counter];
        for(int i = 0; i < counter; i++)
            indices[i] = temp[i];


        return indices;
    }
    /* ==========================================
     *  EXPOSED API / UTILITY
     ============================================*/
    /** @return Formatted string value of the list */
    @Override
    public String toString(){
        String str = "";
        Node current = head;
        while(current!= null){
            str += current.getData() + " -> ";
            current = current.getNext();
        }
        str += "null";
        return str;
    }

    /**
     * @return an integer array of values of the linked list
     */
    public int[] toArray(){

        int[] arr = new int[size];
        Node current = head;
        for(int i = 0; i < size; i++){
            arr[i] = current.getData();
            current = current.getNext();
        }
        return arr;
    }

    /* ==========================================
     *  INTERNAL METHODS / UTILITY
     ============================================*/
    /**
     * Gets node at an index
     * <p></p>
     * @param index the location of the node
     * @return the node of the specified index
     */
    private Node getNodeAtIndex(int index) throws IndexOutOfBoundsException{
        checkIndex(index);

        // Traversal pointer for list
        Node current = head;

        // Gets the node at the specified index
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    /**
     * Checks if index is valid
     * @param index the index to be validated
     * @throws IndexOutOfBoundsException
     */
    private void checkIndex(int index) throws IndexOutOfBoundsException{
        if(index<0 || index>= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
    }

    /**
     * Checks if index is valid for insert
     * @param index the index to be validated
     * @throws IndexOutOfBoundsException
     */
    private void checkIndexForInsert(int index) throws IndexOutOfBoundsException{
        if(index<0 || index> size)
            throw new IndexOutOfBoundsException("Index out of bounds");
    }
}
