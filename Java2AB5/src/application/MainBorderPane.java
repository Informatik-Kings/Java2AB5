package application;

import application.filebrowser.DirectoryTableView;
import application.menu.ApplicationMenuBar;
import de.fhswf.fbin.java2fx.entities.FXFile;
import de.fhswf.fbin.java2fx.trees.DirectoryTreeView;
import exception.InvalidSourceException;
import exception.LoggerFX;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * 
 * MainBorderPane zum Layouten und Testen von {@link DirectoryTableView}, {@link DirectoryTreeView} und {@link ApplicationMenuBar}.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class MainBorderPane extends BorderPane{

   private DirectoryTableView directoryTableView;

   public MainBorderPane() throws InvalidSourceException {
      VBox vbox = new VBox();

      TextField textfield = new TextField();
      ApplicationMenuBar menuBar = new ApplicationMenuBar(textfield);

      setTop(menuBar);
      setBottom(vbox);
      setAlignment(vbox, Pos.CENTER);

      SplitPane splitPane = new SplitPane();
      splitPane.setDividerPositions(0.25);
      DirectoryTreeView directoryTreeView = new DirectoryTreeView();


      splitPane.getItems().add(directoryTreeView);
      setLeft(directoryTreeView);
      setCenter(splitPane);

      this.directoryTableView = new DirectoryTableView();
      splitPane.getItems().add(directoryTableView);
      directoryTreeView.getSelectionModel().selectedItemProperty().addListener(new DirectorySelectionChangeListener());

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
         try {
            directoryTableView.updateTable(newValue);
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
