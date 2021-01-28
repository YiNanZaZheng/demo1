package com.example.demo1.design.pattern.decorator;


public class ComponentDecorator2 extends AbstarctDecorator {

    public ComponentDecorator2(Component component) {
        super(component);
    }

    @Override
    public void Operation() {
        super.Operation();
    }

    public void addFunction2() {
        System.out.println("增加了装饰器方法2");
    }
}
