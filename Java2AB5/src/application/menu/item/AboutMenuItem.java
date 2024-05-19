package application.menu.item;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 * 
 * MenuItem, welches eine Box mit Informationen über die Anwendung öffnet.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class AboutMenuItem extends AbstractApplicationMenuItem {
   
   /**
    * @see {@link AbstractApplicationMenuItem#AbstractApplicationMenuItem(TextField, String, String)} 
    */
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