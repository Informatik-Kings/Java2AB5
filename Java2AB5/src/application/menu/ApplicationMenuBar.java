package application.menu;

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
      FileMenu fileMenu = new FileMenu(textfield);
      ThemesMenu themesMenu = new ThemesMenu(textfield);
      HelpMenu helpMenu = new HelpMenu(textfield);

      this.getMenus().addAll(fileMenu, themesMenu, helpMenu);
   }
}
