package application.filebrowser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import de.fhswf.fbin.java2fx.entities.FXFile;
import de.fhswf.fbin.java2fx.tables.CheckBoxTableCellFactory;
import de.fhswf.fbin.java2fx.tables.LocalDateTimeTableCellFactory;
import de.fhswf.fbin.java2fx.tables.NumberTableCellFactory;
import exception.InvalidSourceException;

/**
 * 
 * Zeigt Metadaten von Dateien in einem bestimmten Verzeichnis an.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class DirectoryTableView extends TableView<FXFile>
{
   /**
    * 
    * Stellt Dateiname, Größe, Änderungsdatum und ob die Datei versteckt ist,
    * tabellarisch dar.
    *
    */
   public DirectoryTableView()
   {
      setPlaceholder(new Label("Keinen Ordner ausgewählt!"));
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
      
      //Spalte für Lesezugriff
      TableColumn<FXFile, Boolean> readableColumn = new TableColumn<>("Lesezugriff");
      readableColumn.setCellValueFactory(new PropertyValueFactory<>("readable"));
      readableColumn.setCellFactory(new CheckBoxTableCellFactory<>());
      readableColumn.setPrefWidth(100);
      
      //Spalte für Schreibzugriff
      TableColumn<FXFile, Boolean> writeableColumn = new TableColumn<>("Schreibzugriff");
      writeableColumn.setCellValueFactory(new PropertyValueFactory<>("writeable"));
      writeableColumn.setCellFactory(new CheckBoxTableCellFactory<>());
      writeableColumn.setPrefWidth(100);
      
      this.getColumns().add(fileColumn);
      this.getColumns().add(lengthColumn);
      this.getColumns().add(lastModifiedColumn);
      this.getColumns().add(hiddenColumn);
      this.getColumns().add(readableColumn);
      this.getColumns().add(writeableColumn);
   }

   /**
    * 
    * Aktuallisiert, was in der Tabelle angezeigt wird.
    *
    * @param directoryPath Pfad zum Directory, von welchem die Dateien angezeigt werden sollen.
    * @throws Exception
    */
   public void updateTable(String directoryPath) throws Exception
   {
      if (directoryPath == null) {
         throw new InvalidSourceException("updateTable(String directoryPath): Ungültige Null-Referenz zu directoryPath!");
      }
      ObservableList<FXFile> data = FXCollections.observableArrayList();
      Files.list(Paths.get(directoryPath))
            .map(Path::toFile)      // Konvertierung von Path zu File
            .filter(File::isFile)   // Filterung von Files
            .map(FXFile::new)       // Konvertierung von File zu FXFile
            .forEach(data::add);    // Hinzufügen zur ObservableList

      this.setItems(data);
   }
}