package application.menu;

import application.menu.item.CaspianMenuItem;
import application.menu.item.ExitMenuItem;
import application.menu.item.AboutMenuItem;
import application.menu.item.ModenaMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

/**
 * MenuBar, zum Layouten von Menus und MenuItems.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class ApplicationMenuBar extends MenuBar
{
   /**
    * 
    * MenuBar mit Datei, Themes und Hilfe Menus.
    *
    * @param textfield Textfeld, auf dass sich die MenuItems beziehen können,
    * um zusätzliche Funktionalität zu Verfügung zu stellen.
    */
   public ApplicationMenuBar(TextField textfield)
   {
      Menu fileMenu = new Menu("Datei");
      Menu themesMenu = new Menu("Themes");
      Menu helpMenu = new Menu("Hilfe");

      fileMenu.getItems().add(new ExitMenuItem(textfield));
      themesMenu.getItems().addAll(new CaspianMenuItem(textfield),
            new ModenaMenuItem(textfield));
      helpMenu.getItems().add(new AboutMenuItem(textfield));

      this.getMenus().addAll(fileMenu, themesMenu, helpMenu);
   }
}
