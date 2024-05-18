package application.menu.item;

import javafx.application.Application;
import javafx.scene.control.TextField;

public class CaspianMenuItem extends AbstractApplicationMenuItem {
    public CaspianMenuItem(TextField textfield) {
        super(textfield, "_CASPIAN", "shortcut+c");
    }

    @Override
    protected void work() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }
}