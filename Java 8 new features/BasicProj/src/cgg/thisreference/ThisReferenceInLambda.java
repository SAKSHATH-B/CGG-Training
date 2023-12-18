package cgg.thisreference;



public class ThisReferenceInLambda {

	public void process() {
	 doOperate(30,n->{
		 System.out.println(30+n);
		 System.out.println(this);
	 });	
	}
	
	public static void main(String[] args) {
		int b=30;
		/*
		 * ThisReferenceInLambda.doOperate(b, new Operation() {
		 * 
		 * @Override public void operate(int n) { System.out.println(b+n);
		 * System.out.println(this); } });
		 */
		
		ThisReferenceInLambda.doOperate(b, n->{
			System.out.println(b+n);
			//System.out.println(this);
		});
		
		new ThisReferenceInLambda().process();

	}
	
	private static void doOperate(int i,Operation o) {
		o.operate(i);
	}

}
