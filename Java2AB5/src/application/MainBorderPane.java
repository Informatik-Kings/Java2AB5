package application;

import application.filebrowser.DirectoryTableView;
import application.menu.ApplicationMenuBar;
import de.fhswf.fbin.java2fx.trees.DirectoryTreeView;
import exception.InvalidSourceException;
import javafx.geometry.Pos;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * 
 * MainBorderPane zum Layouten und Testen von {@link DirectoryTableView}, {@link DirectoryTreeView} und {@link ApplicationMenuBar}.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class MainBorderPane extends BorderPane{

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

      DirectoryTableView directoryTableView = new DirectoryTableView(directoryTreeView);
      splitPane.getItems().add(directoryTableView);

   }

}
