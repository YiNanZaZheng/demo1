package com.example.demo1.exception;

import com.example.demo1.exception.core.BussinessException;
import com.example.demo1.exception.core.IString;
import com.example.demo1.exception.core.Params;

public class CmError {
    public static class ErrorTest{

        public final static String E0000="ErrorTest.E0000";

        private final static IString I_E0000
                = new IString("CmError.ErrorTest.E0000", "系统错误");

        public static String E0000_ERROR() {
            String message = I_E0000.getString();
            return message;
        }

        public static BussinessException E0000() throws BussinessException {
            throw new BussinessException(E0000, new IString(I_E0000, null));
        }

        public static BussinessException E0000(Throwable t) throws BussinessException {
            throw new BussinessException(E0000,new IString(I_E0000, null),t);
        }


        public final static String E0001="ErrorTest.E0001";

        private final static IString I_E0001
                = new IString("CmError.ErrorTest.E0001", "带一个参数的错误提示:[${desc}]");

        public static String E0001_ERROR(String desc) {
            Params context = new Params().add("desc", desc);
            String message = new IString(I_E0001,context).getString();
            return message;
        }

        public static BussinessException E0001(String desc) throws BussinessException {
            Params context = new Params().add("desc", desc);
            throw new BussinessException(E0001, new IString(I_E0001, context));
        }

        public static BussinessException E0001(String desc, Throwable t) throws BussinessException {
            Params context = new Params().add("desc", desc);
            throw new BussinessException(E0001, new IString(I_E0001, context), t);
        }

        public final static String E0002="ErrorTest.E0002";

        private final static IString I_E0002
                = new IString("CmError.ErrorTest.E0002", "带两个参数的错误提示,参数1:[${desc1}]，参数2:[${desc2}]");

        public static String E0002_ERROR(String desc1,String desc2) {
            Params context = new Params().add("desc1", desc1).add("desc2",desc2);
            String message = new IString(I_E0002,context).getString();
            return message;
        }

        public static BussinessException E0002(String desc1,String desc2) throws BussinessException {
            Params context = new Params().add("desc1", desc1).add("desc2",desc2);
            throw new BussinessException(E0002, new IString(I_E0002, context));
        }

        public static BussinessException E0002(String desc1,String desc2, Throwable t) throws BussinessException {
            Params context = new Params().add("desc1", desc1).add("desc2",desc2);
            throw new BussinessException(E0002, new IString(I_E0002, context), t);
        }

    }
}
