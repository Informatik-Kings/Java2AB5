package de.fhswf.fbin.java2fx.tables;

import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class NumberTableCellFactory<S>
      implements
      Callback<TableColumn<S, Number>, TableCell<S, Number>>
{
   @Override
   public TableCell<S, Number> call(
         TableColumn<S, Number> param)
   {
      return (TableCell<S, Number>) new TableCell<S, Number>()
      {
         @Override
         protected void updateItem(Number item, boolean empty)
         {
            super.updateItem(item, empty);

            if (!empty)
            {
               setText(item.toString());
               setAlignment(Pos.TOP_RIGHT);
            }
            else
            {
               setText(null);
            }
         }
      };
   }
}
