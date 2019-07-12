package cn.tedu.xiaomi.service.ex;

public class FileIOException extends FileUploadException{

	private static final long serialVersionUID = 1967210786404832853L;

	public FileIOException() {
		super();
	}

	public FileIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileIOException(String message) {
		super(message);
	}

	public FileIOException(Throwable cause) {
		super(cause);
	}

}
