package application.menu.item;

import javafx.scene.control.TextField;

/**
 * 
 * MenuItem, welches das Programm schließt.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class ExitMenuItem extends AbstractApplicationMenuItem {
   
   /**
    * @see {@link AbstractApplicationMenuItem#AbstractApplicationMenuItem(TextField, String, String)} 
    */
   public ExitMenuItem(TextField textfield) {
       super(textfield, "_Beenden", "shortcut+q");
   }

   @Override
   protected void work() {
       System.exit(0);
   }
}
