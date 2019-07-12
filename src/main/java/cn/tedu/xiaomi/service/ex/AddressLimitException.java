package cn.tedu.xiaomi.service.ex;

public class AddressLimitException extends ServiceException {
    private static final long serialVersionUID = 1709549555509660624L;

    public AddressLimitException() {
        super();
    }

    public AddressLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AddressLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressLimitException(String message) {
        super(message);
    }

    public AddressLimitException(Throwable cause) {
        super(cause);
    }
}
