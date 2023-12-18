package cgg.lamda;

public class Test {

	public static void main(String[] args) {
		/*
		 * Runnable r = ()->System.out.println("Iam Thread...");
		 * 
		 * Thread thread= new Thread(r);
		 * 
		 * thread.start();
		 */

//		MyInterface1 myInterface1 = new MyInterface1() {
//			@Override
//			public void method1() {
//			System.out.println("Anonymous class..");	
//			}
//		}
		
		MyInterface1 myInterface1= ()->System.out.println("This method executes using lamda..");
		myInterface1.method1();
		System.out.println("--------------------------------");
		MyInterface2 myInterface2=name->System.out.println("Your name is "+name);
		myInterface2.method2("ABC");
		MyInterface3 myInterface3=(name,age)->{
			System.out.println("Your name is "+name);
			System.out.println("You are "+age+" old ");
		};
		myInterface3.method3("ABC",20);
		System.out.println("-------------------");
		
		MyComparator myComparator= (n1,n2)->n1>n2;
		
		boolean compare =myComparator.compare(40, 30);
		System.out.println(compare);
	}

}
