package Abstraction;

public class AbstractSubClass extends AbstractClass{
    public AbstractSubClass(){
        super();
        System.out.println("Subclass Constructor...");
    }
    @Override
    public void meth2(){
        System.out.println("Meth2 of sub class");
    }
}
