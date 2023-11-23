package Generics;

public class gen1 {
    Object Box;
    public gen1(Object Box){
        this.Box = Box;
    }
    public Object getValue(){
        return Box;
    }

    public static void main(String[] args) {
        gen1 obj1 = new gen1("Hello");
        gen1 obj2 = new gen1(21);
        System.out.println(obj1.getValue());
        System.out.println(obj2.getValue());
    }
}
