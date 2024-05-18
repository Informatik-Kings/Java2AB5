package de.fhswf.fbin.java2fx.trees;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import de.fhswf.fbin.java2fx.entities.FXFile;
import de.fhswf.fbin.java2fx.util.FileUtils;

public class DirectoryTreeItem extends TreeItem<FXFile>
{
   private boolean isFirstTimeChildren = true;

   private boolean isFirstTimeLeaf = true;

   private boolean isLeaf;

   private File[] subDirectories;

   private static String separator = System.getProperty("file.separator");

   private static boolean isRunningOnWindows = System.getProperty("os.name")
         .toLowerCase().contains("windows");

   public DirectoryTreeItem(File file)
   {
      super(new FXFile(file));

      if (file == null)
//            || (!separator.equals(file.getName()) && !file.isDirectory()))
         throw new IllegalArgumentException("file is null or not a directory");
   }

   @Override
   public boolean isLeaf()
   {
      if (isFirstTimeLeaf)
      {
         isFirstTimeLeaf = false;
         isLeaf = getSubDirectories().length == 0;
      }

      return isLeaf;
   }

   @Override
   public ObservableList<TreeItem<FXFile>> getChildren()
   {
      if (isFirstTimeChildren)
      {
         isFirstTimeChildren = false;

         // First getChildren() call, so we actually go off and
         // determine the children of the File contained in this TreeItem.
         super.getChildren().setAll(buildChildren());
      }

      return super.getChildren();
   }

   private File[] getSubDirectories()
   {
      if (subDirectories == null)
      {
         FXFile dir = (FXFile) getValue();
         System.out.println("\"" + dir.getName() + "\"");

         if (isRunningOnWindows && parentProperty().getValue() == null)
         {
            dir.setName(separator);
            subDirectories = File.listRoots();
            System.out.println("windows detected");
         }
         else
         {
            subDirectories = dir.getFile().listFiles(f -> FileUtils.isPublicDirectory(f));
         }

         if (subDirectories == null)
         {
            System.out.println("oops, something went wrong for "
                  + dir.getName());
            subDirectories = new File[0];
         }
      }

      return subDirectories;
   }

   private ObservableList<TreeItem<FXFile>> buildChildren()
   {
      ObservableList<TreeItem<FXFile>> children = FXCollections
            .observableArrayList();

      for (File subDirectory : getSubDirectories())
      {
         children.add(new DirectoryTreeItem(subDirectory));
      }

      return children;
   }
}
