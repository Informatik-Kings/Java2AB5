package application.menu.item;

import exception.LoggerFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;

/**
 * Basisklasse für Menu-Items welche eine spezielle Funktion zugewiesen bekommen.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */

public abstract class AbstractApplicationMenuItem extends MenuItem
{

   TextField textfield;

   /**
    * 
    * Erstellt ein Menu-Item mit einem festgelegten Handler.
    * Spezifische Aktion für Handler wird durch implementation von {@link AbstractApplicationMenuItem#work()} festgelegt.
    *
    * @param textfield Textfeld, auf welches die Aktionen vom Handler gelten sollen.  
    * @param menuItemName Anzeigename des Menu-Items.
    * @param shortcut Tastenkürzel zur Aktivierung der Menu-Items.
    */
   public AbstractApplicationMenuItem(TextField textfield, String menuItemName, String shortcut)
   {
      super(menuItemName);
      if (textfield == null) {
         throw new IllegalArgumentException("MenuItem: Es wurde kein Textfeld übergeben!");
      }
      if (menuItemName == null) {
         throw new IllegalArgumentException("MenuItem: Es wurde kein Name übergeben!");
      }
      if (shortcut == null) {
         throw new IllegalArgumentException("MenuItem: Es wurde kein Shortcut übergeben!");
      }
      this.textfield = textfield;

      this.setOnAction(new ItemEventHandler());

      this.setAccelerator(KeyCombination.keyCombination(shortcut));
   }

   /**
    * 
    * Handler welcher {@link AbstractApplicationMenuItem#work()} als Aktion für Menu-Item festlegt.
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   protected class ItemEventHandler implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent event)
      {
         try {
            work();
         }catch (Exception e) {
            Alert alert =
                  new Alert(AlertType.ERROR, "Fehler bei Interaktion mit Menu-Item! \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
            alert.setResizable(true);
            alert.showAndWait();
            LoggerFX.log(e, getClass().getSimpleName());
         }         
      }

   }

   /**
    * 
    * Aktion welche ein bestimmtes Menu-Item auslösen soll.
    * Genaue Aktion soll wird durch abgeleitete Klasse bestimmt. 
    *
    */
   protected abstract void work();

}
