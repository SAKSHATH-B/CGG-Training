public class areaOfCircle {
    private double radius;      //Variable created when the object of class is created
    public static final double PI=3.14;       //Variable created when the class is successfully loaded
    public areaOfCircle(double radius){
        System.out.println("This method prints the area of circle with provided radius.!!");
        this.radius = radius;
    }
    private double findingArea(){
        double area;                //Variable created when the method is called
        area = PI*radius*radius;
        return area;
    }
    
    public static void main(String[] args) {
        areaOfCircle c1 = new areaOfCircle(10.00);System.out.println(c1.findingArea());System.out.println(c1.findingArea());
        areaOfCircle c2 = new areaOfCircle(20.00);System.out.println(c2.findingArea());System.out.println(c2.findingArea());
        areaOfCircle c3 = new areaOfCircle(30.00);System.out.println(c3.findingArea());System.out.println(c3.findingArea());
    }
}
