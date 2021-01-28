package com.example.demo1.design.pattern.decorator;

public class MainTest {
    public static void main(String[] args) {
//        ConcreteComponent oldComponent = new ConcreteComponent();
//        ConcreteComponent newComponent = new ComponentDecorator1(new ConcreteComponent());
//        oldComponent.Operation();
//        System.out.println("=======================");
//        newComponent.Operation();


        ConcreteComponent concreteComponent = new ConcreteComponent();

        ComponentDecorator1 componentDecorator1 = new ComponentDecorator1(concreteComponent);
        componentDecorator1.addFunction1();
        componentDecorator1.Operation();
        ComponentDecorator2 componentDecorator2 = new ComponentDecorator2(componentDecorator1);
        componentDecorator2.addFunction2();
    }
}
