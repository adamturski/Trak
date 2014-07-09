package pl.com.turski.exception;

/**
 * User: Adam
 */
public class TechnicalException extends RuntimeException {


    private TechnicalErrorCode errorCode;

    public TechnicalException(String message, TechnicalErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public TechnicalException(String message, Throwable cause, TechnicalErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public TechnicalErrorCode getErrorCode() {
        return errorCode;
    }
}
