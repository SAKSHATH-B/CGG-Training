public class MultipleCatchBlocks {
    static void divide(int x,int y){
        try{
            int ans = x/y;
            System.out.println(ans);
            
            String str = null;
            System.out.println(str.equals("Hello"));

            int a[] = {1};
            a[2] = 12;

        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println("End of main");
    }
    public static void main(String[] args) {
        divide(2, 3);
    }
}
