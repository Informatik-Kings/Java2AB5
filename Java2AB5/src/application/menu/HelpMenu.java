package application.menu;

import application.menu.item.AboutMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class HelpMenu extends Menu
{
   private MenuItem infoItem;

   public HelpMenu(TextField textfield)
   {
      super("_Hilfe");
      if (textfield == null)
      {
         throw new IllegalArgumentException(
               "HelpMenu(TextField textfield): textfield == null!");
      }
      this.infoItem = new AboutMenuItem(textfield);
      getItems().add(infoItem);
   }
}