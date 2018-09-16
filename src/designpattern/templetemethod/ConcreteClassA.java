package designpattern.templetemethod;

public class ConcreteClassA extends AbstractClass {
    @Override
    public void primitiveOper1() {
        System.out.println("具体类A的方法实现1");
    }

    @Override
    public void primitiveOper2() {
        System.out.println("具体类A的方法实现2");
    }
}
