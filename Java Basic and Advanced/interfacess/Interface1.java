package Interfaces;

// star Inheritance

interface B{
    void main2();
}

interface C{
    void main3();
}

interface A extends B,C{
    void main1();
}

interface P extends A{
    void main4();
}

interface Q extends A{
    void main5();
}


// Diamond Inheritance

interface infc1{
    void call1();
    default void de1(){
        System.out.println("This is default for call1 and infc1.");
    }
    public static void se1(){
        System.out.println("This is static for call1 and infc1.");
    }
}
interface infc2 extends infc1{
    void call2();
    void de1();
    // default void de1(){
    //     System.out.println("This is default for call2.");
    // }
    public static void se2(){
        System.out.println("This is static for call2 and infc2.");
    }
}
interface infc3 extends infc1{
    void call3();
}
interface infc4 extends infc2,infc3{
    void call4();
}