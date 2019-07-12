package cn.tedu.xiaomi.service.ex;

/**
 * Created on 2019/6/7 14:13
 *
 * @author Tony
 * @projectName xiaomi
 */
public class ValidateCodeErrorException extends ServiceException {
    private static final long serialVersionUID = -3580435708084431331L;

    public ValidateCodeErrorException() {
    }

    public ValidateCodeErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ValidateCodeErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateCodeErrorException(String message) {
        super(message);
    }

    public ValidateCodeErrorException(Throwable cause) {
        super(cause);
    }
}
