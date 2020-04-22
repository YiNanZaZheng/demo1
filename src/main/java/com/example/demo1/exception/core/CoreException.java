package com.example.demo1.exception.core;

import org.springframework.util.StringUtils;

public abstract class CoreException extends RuntimeException {

    private static final long serialVersionUID = -472430338254144784L;

    private IString str;

    public CoreException() {
    }

    public CoreException(String msg) {
        super(msg);
    }

    public CoreException(IString str) {
        this.str=str;
    }

    public CoreException(IString message, Throwable cause) {
        super(cause);
        this.str=message;
    }

    @Override
    public String getMessage() {
        return getMessage(false);
    }

    private String getMessage(boolean isLocal) {
        String message=null;
        if (str == null) {
            message=super.getMessage();
        }else {
            message=isLocal? str.getLocalString() :str.getString();
        }

        if (StringUtils.isEmpty(this.getCode())) {
            return message;
        }else {
            String Prefix="["+this.getCode()+"}";
            //在此处将message前面拼接上了错误码
            return (message==null||message.startsWith(Prefix))?message:(Prefix+message);
        }
    }

    public abstract String getCode();
}
