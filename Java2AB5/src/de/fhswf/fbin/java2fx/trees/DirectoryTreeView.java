package de.fhswf.fbin.java2fx.trees;

import java.io.File;

import javafx.scene.control.TreeView;
import de.fhswf.fbin.java2fx.entities.FXFile;

public class DirectoryTreeView extends TreeView<FXFile>
{
   public DirectoryTreeView()
   {
      super(new DirectoryTreeItem(new File(System.getProperty("file.separator"))));
      boolean isRunningOnWindows = System.getProperty("os.name")
            .toLowerCase().contains("windows");
      if (isRunningOnWindows) {
         this.setShowRoot(false);
         this.rootProperty().getValue().setExpanded(true);;
      }
   }
}
