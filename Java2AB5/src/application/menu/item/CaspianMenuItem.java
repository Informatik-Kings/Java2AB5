package application.menu.item;

import javafx.application.Application;
import javafx.scene.control.TextField;

/**
 * 
 * MenuItem, welches das Caspian Theme zu Verfügung stellt.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class CaspianMenuItem extends AbstractApplicationMenuItem {
   
   /**
    * @see {@link AbstractApplicationMenuItem#AbstractApplicationMenuItem(TextField, String, String)} 
    */
    public CaspianMenuItem(TextField textfield) {
        super(textfield, "_CASPIAN", "shortcut+c");
    }

    @Override
    protected void work() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }
}