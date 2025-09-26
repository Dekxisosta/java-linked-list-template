package ui;

import datastructures.LinkedList;
import util.Logger;

/**
 * This acts as a view class for the LinkedList model
 * in an MVC architecture
 */
public class ListView {
    private ConsolePrinter printer;

    /**
     * Constructs a List view object
     * @param printer ConsolePrinter object to be used for formatting
     */
    public ListView(ConsolePrinter printer){
        this.printer = printer;
    }

    /**
     * @param list to be shown in its specified tostring format
     * @see LinkedList
     */
    public void showList(LinkedList list){
        printer.print(String.format("%s", list));
    }

    /**
     * Shows an action with an appropriate log label
     * @param action the action performed
     * @param log the label which corresponds to the action
     */
    public void showLog(String action, Logger log){
        printer.log(action, log);
    }

    /** Line break */
    public void showLineBreak(){
        printer.lineBreak();
    }
}
