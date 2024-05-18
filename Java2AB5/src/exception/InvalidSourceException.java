package exception;

/**
 * 
 * Spezialisierung von {@link CustomAppException} gedacht für Fehler, welche auf Programmierfehler
 * zurückzuführen sind (null-Referenzen, fehlerhafte Datenbank-Operationen usw.).
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class InvalidSourceException extends CustomAppException
{

   private static final long serialVersionUID = 8809681455799414552L;

   /**
    * Siehe {@link CustomAppException#CustomAppException()}
    */
   public InvalidSourceException()
   {
      super();
   }

   /**
    * Siehe {@link CustomAppException#CustomAppException(String)}
    */
   public InvalidSourceException(String message)
   {
      super(message);
   }

   /**
    * Siehe {@link CustomAppException#CustomAppException(Throwable)}
    */
   public InvalidSourceException(Throwable cause)
   {
      super(cause);
   }

   /**
    * Siehe {@link CustomAppException#CustomAppException(String, Throwable)} 
    */
   public InvalidSourceException(String message, Throwable cause)
   {
      super(message, cause);
   }

   /**
    * Siehe {@link CustomAppException#CustomAppException(String, Throwable, boolean, boolean)}
    */
   protected InvalidSourceException(String message, Throwable cause,
         boolean enableSuppression, boolean writableStackTrace)
   {
      super(message, cause, enableSuppression, writableStackTrace);
   }

}
