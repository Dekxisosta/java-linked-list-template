package data;

import datastructures.LinkedList;

public class ListData {
    /** Instance field for linked list */
    private LinkedList list;

    /** Constructor for list data */
    public ListData(LinkedList list){
        this.list = list;
    };

    /** @return the list in data */
    public LinkedList getList(){return list;}
}
