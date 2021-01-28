package com.example.demo1.design.pattern.decorator;

public class ConcreteComponent implements Component {

    @Override
    public void Operation() {
        System.out.println("这是具体实现");
    }
}
