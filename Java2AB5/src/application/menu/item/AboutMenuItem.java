package application.menu.item;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AboutMenuItem extends AbstractApplicationMenuItem {
    public AboutMenuItem(TextField textfield) {
        super(textfield, "_Info", "shortcut+i");
    }

    @Override
    protected void work() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Info Dialog");
        alert.showAndWait();
    }
}