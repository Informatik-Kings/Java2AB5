package de.fhswf.fbin.java2fx.entities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FXFile
{
   private static String separator = System.getProperty("file.separator");
   
   private File file;
   
   public FXFile(File file)
   {
      this.file = file;
      setName(this.toString());
      setLastModified(LocalDateTime.ofEpochSecond(file.lastModified()/1000, 0, ZoneOffset.UTC));
      setLength(file.length());
      setHidden(file.isHidden());
      setReadable(file.canRead());
      setWriteable(file.canWrite());
   }

   public File getFile() {
      return this.file;
   }
   
   private StringProperty name;

   public void setName(String value)
   {
      nameProperty().set(value);
   }

   public String getName()
   {
      return nameProperty().get();
   }

   public StringProperty nameProperty()
   {
      if (name == null)
         name = new SimpleStringProperty(this, "name");
      return name;
   }

   private ObjectProperty<LocalDateTime> lastModified;

   public void setLastModified(LocalDateTime value)
   {
      lastModifiedProperty().set(value);
   }

   public LocalDateTime getLastModified()
   {
      return lastModifiedProperty().get();
   }

   public ObjectProperty<LocalDateTime> lastModifiedProperty()
   {
      if (lastModified == null)
         lastModified = new SimpleObjectProperty<LocalDateTime>(this, "lastModified");
      return lastModified;
   }

   private LongProperty length;

   public LongProperty lengthProperty()
   {
      if (length == null)
         length = new SimpleLongProperty(this, "length");
      return length;
   }

   public long getLength()
   {
      return lengthProperty().get();
   }

   public void setLength(long length)
   {
      lengthProperty().set(length);
   }
   
   private BooleanProperty hidden;

   public BooleanProperty hiddenProperty()
   {
      if (hidden == null)
         hidden = new SimpleBooleanProperty(this, "hidden");
      return this.hidden;
   }

   public boolean isHidden()
   {
      return hiddenProperty().get();
   }

   public void setHidden(boolean hidden)
   {
      hiddenProperty().set(hidden);
   }
   
   private BooleanProperty readable;

   public BooleanProperty readableProperty()
   {
      if (readable == null)
         readable = new SimpleBooleanProperty(this, "readable");
      return this.readable;
   }

   public boolean isReadable()
   {
      return readableProperty().get();
   }

   public void setReadable(boolean readable)
   {
      readableProperty().set(readable);
   }
   
   private BooleanProperty writeable;

   public BooleanProperty writeableProperty()
   {
      if (writeable == null)
         writeable = new SimpleBooleanProperty(this, "writeable");
      return this.writeable;
   }

   public boolean isWriteable()
   {
      return writeableProperty().get();
   }

   public void setWriteable(boolean writeable)
   {
      writeableProperty().set(writeable);
   }
   
   @Override
   public String toString()
   {
      String name = file.getName();
      if (!name.isEmpty()) {
      int index = name.lastIndexOf(separator);
      if (index != -1)
         name = name.substring(index);
      }
      else {
         name = file.getAbsolutePath();
      }
      return name;
   }
}
