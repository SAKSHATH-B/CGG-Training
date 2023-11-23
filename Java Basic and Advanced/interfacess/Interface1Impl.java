package Interfaces;

//Star inheritance interfaces

class Interface1Impl implements B,C{
    @Override
    public void main2(){
        System.out.println("This is main2 from Interface1IMPL");
    }

    @Override
    public void main3() {
        System.out.println("Hello main3 from Interface1IMPL");
    }
}
class Interface2Impl implements A{
    @Override
    public void main1(){
        System.out.println("Hello this is main1 from Interface2IMPL");
    }

    @Override
    public void main2() {
        System.out.println("Hello this is main2 from Inteface2IMPL");
    }

    @Override
    public void main3() {
        System.out.println("Hello this is main3 from Inteface2IMPL");
    }
}

class Interface3Impl extends Interface1Impl implements P,Q{
    @Override
    public void main4(){
        System.out.println("Hello main4 from Inteface3IMPL");
    }
    @Override
    public void main5(){
        System.out.println("Hello main5 from Inteface3IMPL");
    }
    @Override
    public void main1() {
        System.out.println("Hello main1 from Inteface3IMPL");
    }
}

// Diamond interfaces inheritance

class inter1 implements infc1{

    @Override
    public void call1() {
        System.out.println("Call1 from inter1 and infc1");
    }
}

class inter2 implements infc2{

    @Override
    public void call1() {
        System.out.println("Call1 from inter2 and infc2");
    }

    @Override
    public void call2() {
        System.out.println("Call2 from inter2 and infc2");
    }

    @Override
    public void de1() {
        System.out.println("This is default declared manually for infc2.");
    }

}

class inter3 implements infc4{

    @Override
    public void call2() {
        System.out.println("Call2 from inter3 and infc4");
    }

    @Override
    public void call1() {
        System.out.println("Call1 from inter3 and infc4");
    }

    @Override
    public void call3() {
        System.out.println("Call3 from inter3 and infc4");
    }

    @Override
    public void call4() {
        System.out.println("Call4 from inter3 and infc4");
    }

    @Override
    public void de1() {
        System.out.println("This is a default method for infc3");
    }

}

