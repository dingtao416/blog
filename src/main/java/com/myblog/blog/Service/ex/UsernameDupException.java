package com.myblog.blog.Service.ex;

public class UsernameDupException extends  BaseException{
    public UsernameDupException() {
        super();
    }

    public UsernameDupException(String message) {
        super(message);
    }

    public UsernameDupException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDupException(Throwable cause) {
        super(cause);
    }

    protected UsernameDupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
