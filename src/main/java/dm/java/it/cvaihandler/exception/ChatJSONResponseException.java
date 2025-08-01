package dm.java.it.cvaihandler.exception;

public class ChatJSONResponseException extends BaseException {

  public ChatJSONResponseException(String message, Exception cause) {
    super("CHAT_JSON_RESPONSE_ERROR", 500, message, cause);
  }
}
