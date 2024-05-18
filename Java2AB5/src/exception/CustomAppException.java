package exception;

/**
 * Spezialisierung von {@link Exception} für JavaFX-Anwendungen
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class CustomAppException extends Exception
{

   private static final long serialVersionUID = 8353085727081991992L;

   /**
    * Siehe {@link Exception#Exception()}
    */
   public CustomAppException()
   {
      super();
   }

   /**
    * Siehe {@link Exception#Exception(String)}
    */
   public CustomAppException(String message)
   {
      super(message);
   }

   /**
    * Siehe {@link Exception#Exception(Throwable)}
    */
   public CustomAppException(Throwable cause)
   {
      super(cause);
   }

   /**
    * Siehe {@link Exception#Exception(String, Throwable)}
    */
   public CustomAppException(String message, Throwable cause)
   {
      super(message, cause);
   }

   /**
    * Siehe {@link Exception#Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)}
    */
   protected CustomAppException(String message, Throwable cause,
         boolean enableSuppression, boolean writableStackTrace)
   {
      super(message, cause, enableSuppression, writableStackTrace);
   }

}
