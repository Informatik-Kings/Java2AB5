package exception;

/**
 * 
 * Spezialisierung von {@link CustomAppException} gedacht für Fehler, welche auf falsche Bedienung
 * zurückzuführen sind (fehlerhafte Dateipfade, ungültige Eingaben, ungültige Logins usw.).
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class InvalidUsageException extends CustomAppException
{

   private static final long serialVersionUID = -8878920311320786844L;

   /**
    * Siehe {@link CustomAppException#CustomAppException()}
    */
   public InvalidUsageException()
   {
      super();
   }

   /**
    * Siehe {@link CustomAppException#CustomAppException(String)}
    */
   public InvalidUsageException(String message)
   {
      super(message);
   }

   /**
    * Siehe {@link CustomAppException#CustomAppException(Throwable)}
    */
   public InvalidUsageException(Throwable cause)
   {
      super(cause);
   }

   /**
    * Siehe {@link CustomAppException#CustomAppException(String, Throwable)} 
    */
   public InvalidUsageException(String message, Throwable cause)
   {
      super(message, cause);
   }

   /**
    * Siehe {@link CustomAppException#CustomAppException(String, Throwable, boolean, boolean)}
    */
   protected InvalidUsageException(String message, Throwable cause,
         boolean enableSuppression, boolean writableStackTrace)
   {
      super(message, cause, enableSuppression, writableStackTrace);
   }

}
