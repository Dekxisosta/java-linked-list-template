package ui;

/* ========================================
 *        MENU OPTIONS CLASS
 ==========================================*/
/** Class dedicated for storing menu options */
public class MenuOptions {
    private static final String[] MENU_OPTIONS = {
        "Exit",  // Must be the first index to maintain choice consistency
        "Add to list",
        "Show list",
        "Update list element",
        "Remove list element"
    };

    /** @return a set of menu options */
    public static String[] getMenuOptions(){
        return MENU_OPTIONS;
    }
}
