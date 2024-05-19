package application.menu;

import application.menu.item.CaspianMenuItem;
import application.menu.item.ModenaMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * 
 * ThemesMenu, welches Menupunkte zum Ändern des Themes bereitstellt.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class ThemesMenu extends Menu
{
   private MenuItem caspianItem;
   private MenuItem modenaItem;

   /**
    * @see {@link Menu#Menu(String)} 
    */
   public ThemesMenu(TextField textfield)
   {
      super("_Themes");
      if (textfield == null)
      {
         throw new IllegalArgumentException(
               "ThemesMenu(TextField textfield): textfield == null!");
      }
      this.caspianItem = new CaspianMenuItem(textfield);
      this.modenaItem = new ModenaMenuItem(textfield);

      getItems().addAll(caspianItem, modenaItem);
   }
}