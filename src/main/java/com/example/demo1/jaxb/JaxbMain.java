package com.example.demo1.jaxb;

import com.example.demo1.jaxb.pojo.PJSBean;
import javassist.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JaxbMain {
    //List<Validator> validatorList;
    public static void main(String[] args) throws JAXBException, IllegalAccessException {
        File file = new File("C:\\Users\\61484\\Desktop\\reder.pjs");
        JAXBContext context = JAXBContext.newInstance(PJSBean.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PJSBean pjsBean = (PJSBean) unmarshaller.unmarshal(file);
        //validatorList(pjsBean);
        pjsBean.Validating();
        System.out.println(pjsBean);

    }
}
