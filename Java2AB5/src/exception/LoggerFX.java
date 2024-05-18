/**
 * 
 */
package exception;

import java.io.File;
import java.io.PrintStream;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Utility-Klasse zum loggen von Fehlern, mit Anzeige von JavaFX
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public final class LoggerFX
{
   /**
    * 
    * Konstruktor privat um Instanzierung zu verhindern (Utility-Klasse)
    *
    */
   private LoggerFX() {
      
   }
   
   /**
    * 
    * Loggt einen Fehler.
    *
    * @param e Die Exception die geloggt werden soll.
    * @param className Der Name der Klasse, von der die Exception geloggt wird.
    */
   public static void log(Exception e, String className) {
      try 
      {
         
         String logFile = System.getProperty("user.home") +
               File.separatorChar + className + ".log";
         Alert alert = new Alert(AlertType.INFORMATION, "Log-Datei unter " + logFile + " erstellt!");
         e.printStackTrace(new PrintStream(logFile));
         alert.showAndWait();
      }
      catch(Exception e1)
      {
         Alert alert = new Alert(AlertType.ERROR, "Fehler beim Erstellen der Log-Datei!");
         alert.showAndWait();
      }
   }
}
