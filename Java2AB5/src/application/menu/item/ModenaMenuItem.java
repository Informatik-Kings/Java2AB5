package application.menu.item;

import javafx.application.Application;
import javafx.scene.control.TextField;

public class ModenaMenuItem extends AbstractApplicationMenuItem {
    public ModenaMenuItem(TextField textfield) {
        super(textfield, "_MODENA", "shortcut+m");
    }

    @Override
    protected void work() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }
}