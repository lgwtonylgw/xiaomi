package cn.tedu.xiaomi.service.ex;

/**
 * Created on 2019/6/3 19:33
 *
 * @author Tony
 * @projectName xiaomi
 */
public class EmailNotSendException extends ServiceException {
    private static final long serialVersionUID = -4392982863257704508L;

    public EmailNotSendException() {
    }

    public EmailNotSendException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmailNotSendException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailNotSendException(String message) {
        super(message);
    }

    public EmailNotSendException(Throwable cause) {
        super(cause);
    }
}
