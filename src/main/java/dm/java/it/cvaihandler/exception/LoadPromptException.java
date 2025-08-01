package dm.java.it.cvaihandler.exception;

public class LoadPromptException extends BaseException {

  public LoadPromptException(String message, Exception cause) {
    super("INTERNAL_SERVER_ERROR", 500, message, cause);
  }
}
