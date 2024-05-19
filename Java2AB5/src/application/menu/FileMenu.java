package application.menu;

import application.menu.item.ExitMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * 
 * FileMenu, welches Menupunkte für Dateien bereitstellt.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class FileMenu extends Menu
{
   private MenuItem exitItem;

   /**
    * @see {@link Menu#Menu(String)} 
    */
   public FileMenu(TextField textfield)
   {
      super("_Datei");
      if (textfield == null)
      {
         throw new IllegalArgumentException(
               "FileMenu(TextField textfield): textfield == null!");
      }
      this.exitItem = new ExitMenuItem(textfield);
      getItems().add(exitItem);
   }
}