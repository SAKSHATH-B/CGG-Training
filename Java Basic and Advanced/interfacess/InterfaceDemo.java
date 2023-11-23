package Interfaces;


interface FirstInterface{
    public void meth1();
}
interface SecondInterface{
    public void meth2();
}

class Firstclass implements FirstInterface{
    public void meth1(){
        System.out.println("This is meth1 with First Interface");
    }
}
class Secondclass implements FirstInterface{
    public void meth1(){
        System.out.println("This is meth1 with Second Interface");
    }
}
class Thirdclass implements FirstInterface,SecondInterface{
    public void meth1(){
        System.out.println("This is ThirdClass with meth1");
    }
    public void meth2(){
        System.out.println("This is ThirdClass with meth2");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        Firstclass obj1 = new Firstclass();
        obj1.meth1();
        Secondclass obj2 = new Secondclass();
        obj2.meth1();
        Thirdclass obj3 = new Thirdclass();
        obj3.meth1();
        obj3.meth2();
    }
}
