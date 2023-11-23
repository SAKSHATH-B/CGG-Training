public class MultiCatchBlock {
    // List only subclasses and do not mention any superclass in catch block separated with | symbol.
    static void divide(int x,int y){
        try{
            int ans = x/y;
            System.out.println(ans);
            
            String str = null;
            System.out.println(str.equals("Hello"));

            int a[] = {1};
            a[2] = 12;

        }
        catch(ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println(e);

        System.out.println("End of main");

        }
    }
        
    public static void main(String[] args) {
        
        divide(2, args.length);
    }
}
