package controller;

import data.ListData;
import datastructures.*;
import ui.ListView;
import util.*;

/**
 * Controller for managing list operations.
 *
 * Depends on {@link LinkedList}, {@link ListView}, and {@link Logger}.
 */
public class ListController {
    private LinkedList list;
    private ListView view;

    /** Constructs a list controller with data source and view. */
    public ListController(ListData data, ListView view) {
        this.list = data.getList();
        this.view = view;
    }

    /** Adds an element at the end of the list. */
    public void addLast(int value) {
        view.showLog("Adding element with value " + value + " to list...", Logger.SYSTEM);
        list.addLast(value);
        view.showLog("Successfully added element!", Logger.SYSTEM);
        view.showLineBreak();
    }

    /** Removes the last element of the list if not empty. */
    public void removeLast() {
        view.showLog("Removing last element... ", Logger.SYSTEM);
        if (!list.isEmpty()) {
            int last = list.getLast();
            list.removeLast();
            view.showLog("Successfully removed last element valued " + last + "!", Logger.SYSTEM);
        } else {
            view.showLog("List is empty!", Logger.ERROR);
        }
        view.showLineBreak();
    }

    /** Displays the contents of the list. */
    public void showList() {
        view.showLog("Showing list...", Logger.SYSTEM);
        view.showList(list);
        view.showLineBreak();
    }

    /** Sets the value of a node at the specified index. */
    public void setAtIndex(int data, int index) throws IndexOutOfBoundsException, EmptyListException {
        view.showLog("Setting " + data + " at index " + index +"...", Logger.SYSTEM);

        if(list.isEmpty())
            throw new EmptyListException();

        int previous = list.getAtIndex(index);
        list.setAtIndex(data, index);
        view.showLog("Successfully replaced value " + previous + " at index "+ index + " with value " + data + "!", Logger.SYSTEM);
    }
}
