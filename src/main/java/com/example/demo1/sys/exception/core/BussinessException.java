package com.example.demo1.sys.exception.core;

public class BussinessException extends CoreException {

    private static final long serialVersionUID = 3645216663987118732L;

    private String code;
    //TODO:ErrorType类待研究
    private String type="error";

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(){
    }
    public BussinessException(String code, String message) {
        super(message);
        this.code=code;
    }
    public BussinessException(String code, IString message) {
        super(message);
        this.code=code;
    }
    public BussinessException(String code, IString message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }
    public String getType() {
        return type;
    }

    @Override
    public String getCode() {
        return code;
    }
}
