package de.fhswf.fbin.java2fx.util;

import java.io.File;

public final class FileUtils
{
   private FileUtils()
   {
   }

   public static boolean isPublicDirectory(File dir)
   {
      return dir.isDirectory() && dir.canRead() && !dir.isHidden();
   }
}
