package com.example.demo1;

import com.example.demo1.jaxb.pojo.PJSBean;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class PjsStartingApplication implements ApplicationListener<ApplicationStartingEvent> {
    private  Set<PJSBean> pjsBeans =new HashSet<>();
    private  Set<String> beanNames =new HashSet<>();


    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        SpringApplication source = (SpringApplication) event.getSource();

        log.info("====ApplicationStartingEvent:开始加载pjs资源====");
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resourcePatternResolver.getResources("classpath:*.pjs");
            for(Resource r : resources) {
                JAXBContext context = JAXBContext.newInstance(PJSBean.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                PJSBean pjsBean = (PJSBean) unmarshaller.unmarshal(r.getInputStream());
                pjsBean.Validating();
                beanNames.add(pjsBean.getClassName());
                pjsBeans.add(pjsBean);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        createClazz(pjsBeans);
        source.setSources(beanNames);
    }

    private void createClazz(Set<PJSBean> pjsBeans) {
        for (PJSBean pjsBean : pjsBeans) {
            ClassPool pool = ClassPool.getDefault();
            CtClass cls = pool.makeClass(pjsBean.getClassName());
            try {
                cls.setInterfaces(new CtClass[]{pool.get("com.example.demo1.sys.JavasInter")});
                //类上增加注解
                addAnnotations(cls);
                createMethodByPJSBean(pool,cls,pjsBean);
                Class aClass = cls.toClass();
                /*ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                Class<?> aClass1 = classLoader.loadClass("com.example.demo1.sys.DemoCreate");
                java.lang.annotation.Annotation[] annotations = aClass1.getAnnotations();
                System.out.println(annotations);
                Object o = aClass1.newInstance();
                System.out.println(aClass1);*/

                cls.writeFile("E:\\demo1");
                System.out.println("");
            } catch (CannotCompileException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
    @Order
    private void createMethodByPJSBean(ClassPool pool,CtClass cls,PJSBean pjsBean) throws Exception{
        ClassFile ccFile = cls.getClassFile();
        ConstPool constpool = ccFile.getConstPool();
        //创建reader方法，指定返回值类型及送入参数类型
        CtClass JdbcBatchItemWriter = pool.get(int.class.getName());
        CtMethod ctMethod = new CtMethod(JdbcBatchItemWriter, "reader",
                new CtClass[]{pool.get(DataSource.class.getName())}, cls);
        //指定权限修饰符
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody(buildMethodBoby(pjsBean));
        //方法上增加注解
        AnnotationsAttribute methodAttr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
        Annotation beanAnnotation = new Annotation("org.springframework.context.annotation.Bean",constpool);
        ArrayMemberValue memberValue = new ArrayMemberValue(constpool);
        //memberValue.setValue();

        beanAnnotation.addMemberValue("name",new StringMemberValue("ceshi",constpool));
        methodAttr.addAnnotation(beanAnnotation);
        MethodInfo info = ctMethod.getMethodInfo();
        info.addAttribute(methodAttr);
        //增加方法
        cls.addMethod(ctMethod);

    }

    private String buildMethodBoby(PJSBean pjsBean) {
        Map<String, String> mapParamMappings = pjsBean.getDbReader().getMapParamMappings();
        Map<String, String> mapParamValues = pjsBean.getDbReader().getMapParamValues();
        String methodStr="return new org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder()" +
                "            .itemSqlParameterSourceProvider(new org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider())\n" +
                "            .sql(\"INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)\")\n" +
                "                .dataSource($1)\n" +
                "                .build();";
        //指定方法体
        return methodStr;
    }

    private AnnotationsAttribute addAnnotations(CtClass cls) {
        ClassFile ccFile = cls.getClassFile();
        ConstPool constpool = ccFile.getConstPool();
        AnnotationsAttribute classAttr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
        Annotation configuration = new Annotation("org.springframework.core.annotation.Order",constpool);
        configuration.addMemberValue("basePackages",new StringMemberValue(11,constpool));
        classAttr.addAnnotation(configuration);
        ccFile.addAttribute(classAttr);
        return classAttr;
    }
}
