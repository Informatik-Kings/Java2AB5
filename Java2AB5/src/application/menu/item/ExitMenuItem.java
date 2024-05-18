package application.menu.item;

import javafx.scene.control.TextField;

public class ExitMenuItem extends AbstractApplicationMenuItem {
   public ExitMenuItem(TextField textfield) {
       super(textfield, "_Beenden", "shortcut+q");
   }

   @Override
   protected void work() {
       System.exit(0);
   }
}
