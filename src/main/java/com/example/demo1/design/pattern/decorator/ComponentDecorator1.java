package com.example.demo1.design.pattern.decorator;

import org.springframework.beans.factory.annotation.Autowired;


public class ComponentDecorator1 extends AbstarctDecorator {

    public ComponentDecorator1(Component component) {
        super(component);
    }

    @Override
    public void Operation() {
        super.Operation();
    }

    public void addFunction1() {
        System.out.println("增加了装饰器方法1");
    }
}
