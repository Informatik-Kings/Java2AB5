package de.fhswf.fbin.java2fx.tables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;

public class DatePickerTableCell<S> extends TableCell<S, LocalDate>
{
   private DatePicker datePicker;

   @Override
   public void startEdit()
   {
      if (!isEmpty())
      {
         super.startEdit();
         createDatePicker();
         setText(null);
         setGraphic(datePicker);
      }
   }

   @Override
   public void cancelEdit()
   {
      super.cancelEdit();

      setText(getItem().format(DateTimeFormatter.RFC_1123_DATE_TIME));
      setGraphic(null);
   }

   @Override
   public void updateItem(LocalDate item, boolean empty)
   {
      super.updateItem(item, empty);

      if (empty)
      {
         setText(null);
         setGraphic(null);
      }
      else
      {
         if (isEditing())
         {
            if (datePicker != null)
            {
               datePicker.setValue(item);
            }
            setText(null);
            setGraphic(datePicker);
         }
         else
         {
            setText(item.format(DateTimeFormatter.RFC_1123_DATE_TIME));
            setGraphic(null);
         }
      }
   }

   private void createDatePicker()
   {
      datePicker = new DatePicker();
      datePicker.setValue(getItem());
      datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
      datePicker.focusedProperty().addListener(new ChangeListener<Boolean>()
      {
         @Override
         public void changed(ObservableValue<? extends Boolean> arg0,
               Boolean oldVAlue, Boolean newValue)
         {
            if (!newValue)
            {
               commitEdit(datePicker.getValue());
            }
         }
      });
   }

   private String getString()
   {
      return getItem() == null ? "" : getItem().format(DateTimeFormatter.RFC_1123_DATE_TIME);
   }
}
