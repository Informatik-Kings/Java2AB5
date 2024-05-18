package de.fhswf.fbin.java2fx.tables;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;

public class CheckBoxTableCellFactory<S> implements Callback<TableColumn<S, Boolean>, TableCell<S, Boolean>>
{
   @Override
   public TableCell<S, Boolean> call(
         TableColumn<S, Boolean> param)
   {
      return new CheckBoxTableCell<S, Boolean>();
   }
}
