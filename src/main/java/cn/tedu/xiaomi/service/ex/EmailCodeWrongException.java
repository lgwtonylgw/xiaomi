package cn.tedu.xiaomi.service.ex;

/**
 * Created on 2019/6/3 19:47
 *
 * @author Tony
 * @projectName xiaomi
 */
public class EmailCodeWrongException extends ServiceException {
    private static final long serialVersionUID = 8164574593519001416L;

    public EmailCodeWrongException() {
    }

    public EmailCodeWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmailCodeWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailCodeWrongException(String message) {
        super(message);
    }

    public EmailCodeWrongException(Throwable cause) {
        super(cause);
    }
}
