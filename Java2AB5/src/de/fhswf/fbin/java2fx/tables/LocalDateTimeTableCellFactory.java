package de.fhswf.fbin.java2fx.tables;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class LocalDateTimeTableCellFactory<S> implements
      Callback<TableColumn<S, LocalDateTime>, TableCell<S, LocalDateTime>>
{
   @Override
   public TableCell<S, LocalDateTime> call(TableColumn<S, LocalDateTime> param)
   {
      return new TableCell<S, LocalDateTime>()
      {
         @Override
         protected void updateItem(LocalDateTime item, boolean empty)
         {
            super.updateItem(item, empty);

            if (!empty)
            {
               ZonedDateTime zdt = ZonedDateTime.of(item, ZoneId.systemDefault());
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); //Deutsches Format
               setText(zdt.format(formatter));
               setAlignment(Pos.TOP_RIGHT); //Rechtsbündig
            }
            else
            {
               setText(null);
            }
         }
      };
   }
}
