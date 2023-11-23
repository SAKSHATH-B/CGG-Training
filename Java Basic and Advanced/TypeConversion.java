public class TypeConversion {
    public static void main(String[] args) {
        double a = 5.75;
        int x = (int)a;
        System.out.println(x);

        int z = 55;
        double y = z;
        System.out.println(y);

        double m = 55;
        long n = (long)m;
        System.out.println(n);

        //byte b = 126;
        int c = 280;
        byte d = (byte)c;
        System.out.println(d);

        float f = 3.1415f;
        int g = (int)f;
        System.out.println(g); 
        
        int one = 1;
        float two = one;
        System.out.println(two);

        char ch = 'A';
        int cha = ch;
        System.out.println(cha);
    }    
}

/* Type Conversions
 * byte --> int, float, double, long, short
 * short --> int, float, long, double
 * char --> int, float, long, double
 * int --> float, long, double
 * long --> Float, double
 * float --> double
 */