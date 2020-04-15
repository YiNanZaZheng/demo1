package com.example.simplespring.ioc.xml;

import com.example.simplespring.ioc.BeanDefinitionReader;
import com.example.simplespring.ioc.entity.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;
    public XmlBeanDefinitionReader(String location) {
        registry=new HashMap<>();
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception{
        FileInputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) throws Exception {
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                pareBeanDefinition(element);
            }
        }
    }

    private void pareBeanDefinition(Element element) {

    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext();
    }

}
