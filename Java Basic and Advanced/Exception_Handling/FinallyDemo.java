public class FinallyDemo {
    
    static int divide(int x, int y){
        int ans=0;
        try{
            ans=x/y;
        }
        catch(Exception e){
            ans = 0;
        }
        finally{
            return ans;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(divide(4,0));
    }
}
