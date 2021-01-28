package com.example.demo1.design.pattern.decorator;

public abstract class AbstarctDecorator implements Component {

    private Component component;

    public AbstarctDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void Operation() {
        component.Operation();
    }
}
