package designpattern.decorator;

public class Main {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        Decorator d1 = new ConcreteDecoratorA();
        Decorator d2 = new ConcreteDecoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);

        d2.operation();
    }
}
