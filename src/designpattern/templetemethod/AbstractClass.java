package designpattern.templetemethod;

abstract class AbstractClass {
    public abstract void primitiveOper1();
    public abstract void primitiveOper2();

    public void templateMethod(){
        primitiveOper1();
        primitiveOper2();
        System.out.println();
    }
}
