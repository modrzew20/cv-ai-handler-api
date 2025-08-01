package dm.java.it.cvaihandler.exception;

import com.fasterxml.jackson.databind.ser.Serializers.Base;

public class PDFProcessingException extends BaseException {

  public PDFProcessingException(String message, Exception cause) {
    super("PDF_PROCESSING_ERROR", 400, message, cause);
  }
}
