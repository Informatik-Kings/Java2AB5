package application.menu.item;

import javafx.application.Application;
import javafx.scene.control.TextField;

/**
 * 
 * MenuItem, welches das Modena Theme zu Verfügung stellt.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class ModenaMenuItem extends AbstractApplicationMenuItem {
   
   /**
    * @see {@link AbstractApplicationMenuItem#AbstractApplicationMenuItem(TextField, String, String)} 
    */
    public ModenaMenuItem(TextField textfield) {
        super(textfield, "_MODENA", "shortcut+m");
    }

    @Override
    protected void work() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }
}