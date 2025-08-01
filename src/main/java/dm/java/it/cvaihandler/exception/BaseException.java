package dm.java.it.cvaihandler.exception;

import lombok.Getter;

/**
 * BaseException is a custom exception class that extends RuntimeException. It is used to represent application-specific exceptions with additional information such as error code, HTTP status, and
 * messages for internal and external use.
 */
@Getter
public class BaseException extends RuntimeException {

  private final String errorCode;
  private final int httpStatus;
  private final String message;
  private final Exception cause;

  /**
   * Constructs a new BaseException with the specified error code, HTTP status, message, and cause.
   *
   * @param errorCode  the error code representing the type of error
   * @param httpStatus the HTTP status code associated with the error
   * @param message    the message for internal use
   * @param cause      the underlying cause of the exception
   */
  public BaseException(String errorCode, int httpStatus, String message, Exception cause) {
    super(message, cause);
    this.errorCode = errorCode;
    this.httpStatus = httpStatus;
    this.message = message;
    this.cause = cause;
  }
}

