package application.menu;

import application.menu.item.ExitMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class FileMenu extends Menu
{
   private MenuItem exitItem;

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