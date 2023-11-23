package Abstraction;

public abstract class AbstractClass {
    public AbstractClass(){
        System.out.println("Superclass Constructor...");
    }
    public void meth1(){
        System.out.println("Meth1 of parent class");
    }
    abstract public void meth2();
}
