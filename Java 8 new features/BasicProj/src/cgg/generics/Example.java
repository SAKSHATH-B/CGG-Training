package cgg.generics;

public class Example {

	public static void main(String[] args) {
		//Box box = new Box("water");
		
//		Box box = new Box(45);
//		box.container="This is String";
//		System.out.println(box.getValue());
		
		//this is not type safe
		//generics will create general variable as well as type safety
		
		Box<String> box = new Box<>("This is amazing");
		System.out.println(box.getValue());
		System.out.println(box.container.getClass().getName());
		
		Box<Integer> box1 = new Box<>(123);
		System.out.println(box1.getValue());
		System.out.println(box1.container.getClass().getName());
		
		//error 
		//box.container=123;
		//box1.container="one";
		
		Box<Boolean> box2 = new Box<>(true);
		System.out.println(box2.getValue());
		System.out.println(box2.container.getClass().getName());
		
		box.performSomeTask();
		box1.performSomeTask();
	}

}
