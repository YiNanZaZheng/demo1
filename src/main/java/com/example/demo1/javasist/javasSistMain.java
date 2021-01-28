package com.example.demo1.javasist;

import javassist.*;
import javassist.bytecode.*;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;

import javax.sql.DataSource;
import java.io.IOException;


public class javasSistMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 创建类
        ClassPool pool = ClassPool.getDefault();
        CtClass cls = pool.makeClass("com.situ.super.Sclass");
        ClassFile ccFile = cls.getClassFile();
        ConstPool constpool = ccFile.getConstPool();
        try {
            //类上增加注解
            AnnotationsAttribute classAttr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
            Annotation configuration = new Annotation("org.springframework.context.annotation.Configuration",constpool);
            Annotation enableBatchProcessing = new Annotation("org.springframework.batch.core.configuration.annotation.EnableBatchProcessing",constpool);
            classAttr.addAnnotation(configuration);
            classAttr.addAnnotation(enableBatchProcessing);
            ccFile.addAttribute(classAttr);

            //创建reader方法，指定返回值类型及送入参数类型
            CtClass JdbcBatchItemWriter = pool.get(JdbcBatchItemWriter.class.getName());
            CtMethod ctMethod = new CtMethod(JdbcBatchItemWriter, "reader",
                    new CtClass[]{pool.get(DataSource.class.getName())}, cls);
            //指定权限修饰符
            ctMethod.setModifiers(Modifier.PUBLIC);

            String methodStr="return new org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder()" +
                    "            .itemSqlParameterSourceProvider(new org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider())\n" +
                    "            .sql(\"INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)\")\n" +
                    "                .dataSource($1)\n" +
                    "                .build();";
            //指定方法体
            ctMethod.setBody(methodStr);
            //方法上增加注解
            AnnotationsAttribute methodAttr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
            Annotation beanAnnotation = new Annotation("org.springframework.context.annotation.Bean",constpool);
            beanAnnotation.addMemberValue("name",new StringMemberValue("ceshi",constpool));
            methodAttr.addAnnotation(beanAnnotation);
            MethodInfo info = ctMethod.getMethodInfo();
            info.addAttribute(methodAttr);
            //增加方法
            cls.addMethod(ctMethod);
            System.out.println(cls.toClass());
            Class<?> aClass = Class.forName("com.situ.super.Sclass");
            cls.writeFile("D://Emp1.class");

        } catch (CannotCompileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
