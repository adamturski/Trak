package pl.com.turski.exception;

/**
 * User: Adam
 */
public class BusinessException extends RuntimeException {

    private BusinessErrorCode errorCode;

    public BusinessException(String message, BusinessErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Throwable cause, BusinessErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BusinessErrorCode getErrorCode() {
        return errorCode;
    }
}
