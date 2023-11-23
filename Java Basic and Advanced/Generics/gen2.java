package Generics;

public class gen2<T> {
    T ap;
    public gen2(T ap){
        this.ap=ap;
    }
    public T me2(){
        return ap;
    }

    public static void main(String[] args) {
        gen2<String> g = new gen2<>("Helo BSDK");
        gen2<Float> g1 = new gen2<>(22.2f);
        System.out.println(g.me2());
        System.out.println(g1.me2());
    }
}
