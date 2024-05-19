package application.filebrowser;

import java.io.File;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import de.fhswf.fbin.java2fx.entities.FXFile;
import de.fhswf.fbin.java2fx.tables.CheckBoxTableCellFactory;
import de.fhswf.fbin.java2fx.tables.LocalDateTimeTableCellFactory;
import de.fhswf.fbin.java2fx.tables.NumberTableCellFactory;
import de.fhswf.fbin.java2fx.trees.DirectoryTreeView;
import exception.InvalidSourceException;
import exception.LoggerFX;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * 
 * Zeigt Metadaten von Dateien in einem bestimmten Verzeichnis an.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class DirectoryTableView extends TableView<FXFile>
{
   DirectoryTreeView directoryTreeView;

   /**
    * 
    * Stellt Dateiname, Größe, Änderungsdatum und ob die Datei versteckt ist,
    * tabellarisch dar.
    * @param directoryTreeView Stellt den Baum tabellarisch dar.
    * @throws InvalidSourceException Wenn Ungültige Null-Referenz übergeben wurde.
    *
    */
   public DirectoryTableView(DirectoryTreeView directoryTreeView) throws InvalidSourceException
   {
      if(directoryTreeView == null) {
         throw new InvalidSourceException("DirectoryTableView(DirectoryTreeView directoryTreeView): Ungültige Null-Referenz zu directoryTreeView");
      }
      this.directoryTreeView = directoryTreeView;
      this.directoryTreeView.getSelectionModel().selectedItemProperty().addListener(new DirectorySelectionChangeListener());
      //Spalte für Dateinamen
      TableColumn<FXFile, String> fileColumn = new TableColumn<>("Datei");
      fileColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
      fileColumn.setPrefWidth(350);

      //Spalte für Dateigröße
      TableColumn<FXFile, Number> lengthColumn = new TableColumn<>("Größe");
      lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
      lengthColumn.setCellFactory(new NumberTableCellFactory<>());
      lengthColumn.setPrefWidth(100);

      //Spalte für letzte Änderung
      TableColumn<FXFile, LocalDateTime> lastModifiedColumn = new TableColumn<>("Zuletzt modifiziert");
      lastModifiedColumn.setCellValueFactory(new PropertyValueFactory<>("lastModified"));
      lastModifiedColumn.setCellFactory(new LocalDateTimeTableCellFactory<>());
      lastModifiedColumn.setPrefWidth(200);

      //Spalte für versteckt
      TableColumn<FXFile, Boolean> hiddenColumn = new TableColumn<>("Versteckt");
      hiddenColumn.setCellValueFactory(new PropertyValueFactory<>("hidden"));
      hiddenColumn.setCellFactory(new CheckBoxTableCellFactory<>());
      hiddenColumn.setPrefWidth(100);

      this.getColumns().add(fileColumn);
      this.getColumns().add(lengthColumn);
      this.getColumns().add(lastModifiedColumn);
      this.getColumns().add(hiddenColumn);
   }

   /**
    * 
    * Ändert den Inhalt der {@link DirectoryTableView}, anhand des selektierten Ordners. 
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   private class DirectorySelectionChangeListener implements ChangeListener<TreeItem<FXFile>> {
      @Override
      public void changed(ObservableValue<? extends TreeItem<FXFile>> observable, TreeItem<FXFile> oldValue, TreeItem<FXFile> newValue) {
         if (newValue != null && newValue.getValue().getFile().isDirectory()) {
            try {

               ObservableList<FXFile> data = FXCollections.observableArrayList();
               Files.list(Paths.get(newValue.getValue().getFile().getPath()))
               .map(Path::toFile)      // Konvertierung von Path zu File
               .filter(File::isFile)   // Filterung von Files
               .map(FXFile::new)       // Konvertierung von File zu FXFile
               .forEach(data::add);    // Hinzufügen zur ObservableList

               setItems(data);

            } catch (AccessDeniedException e) {
               Alert alert =
                     new Alert(AlertType.ERROR, "Fehlende Zugriffsberechtigung für den Ordner! \nSenden Sie den Log an den Systemadministrator!", ButtonType.OK);
               alert.setResizable(true);
               alert.showAndWait();
               LoggerFX.log(e, getClass().getSimpleName());
            } catch (Exception e) {
               Alert alert =
                     new Alert(AlertType.ERROR, "Fehler beim Updaten der Tabelle! \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
               alert.setResizable(true);
               alert.showAndWait();
               LoggerFX.log(e, getClass().getSimpleName());
            }
         }
      }
   }
}