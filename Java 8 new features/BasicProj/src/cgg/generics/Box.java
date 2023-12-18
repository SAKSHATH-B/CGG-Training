package cgg.generics;

//public class Box {
//	
//	Object container;
//
//	public Box(Object container) {
//		super();
//		this.container = container;
//	}
//	
//	public Object getValue() {
//		return this.container;
//	}
//
//}

public class Box<T>{
	
	T container;
	
	public Box(T container) {
		this.container=container;
	}
	
	public void performSomeTask() {
		if(container instanceof String) {
			System.out.println("length of "+container+" is "+ ((String)this.container).length());
		}
		else if(container instanceof Integer) {
			System.out.println("This is Integer value "+container);
		}
	}
	public T getValue() {
		return this.container;
	}
}