package application.filebrowser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class DirectoryTableView extends TableView<FXFile>
{
   public DirectoryTableView()
   {
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

      this.getColumns().addAll(fileColumn, lengthColumn, lastModifiedColumn, hiddenColumn);
   }

   public void updateTable(String directoryPath) throws Exception
   {
      ObservableList<FXFile> data = FXCollections.observableArrayList();
      Files.list(Paths.get(directoryPath))
            .map(Path::toFile)      // Konvertierung von Path zu File
            .filter(File::isFile)   // Filterung von Files
            .map(FXFile::new)       // Konvertierung von File zu FXFile
            .forEach(data::add);    // Hinzufügen zur ObservableList

      this.setItems(data);
   }
}