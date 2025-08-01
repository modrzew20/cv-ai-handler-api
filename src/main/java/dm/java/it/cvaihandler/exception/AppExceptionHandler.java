package dm.java.it.cvaihandler.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler {

  /**
   * Handles BaseException and returns a standardized error response.
   *
   * @param ex the BaseException to handle
   * @return an ErrorDTO containing the error message and code
   */
  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorDTO> handleBaseException(BaseException ex) {
    log.warn("{} ({})", ex.getMessage(), ex.getErrorCode(), ex.getCause());
    return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorDTO(ex.getMessage(), ex.getErrorCode()));
  }

  @Setter
  @Getter
  public static class ErrorDTO {
    private String message;
    private String code;

    public ErrorDTO(String message, String code) {
      this.message = message;
      this.code = code;
    }
  }
}


