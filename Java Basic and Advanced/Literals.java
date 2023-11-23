public class Literals {
    
    public static void main(String[] args) {
        int x = 999999999;  // Integer
        int num = 0b11010;    // Binary Number
        System.out.println(num);

        int num2 = 0x7F;    // Hexa decimal Number
        System.out.println(num2);
    
        int num3 = 10_00_00_000;    //Any number of Underscores in between numbers
        System.out.println(num3);

        long num4 = 999999999999900000l;
        System.out.println(num4);

        float num5 = 732_999.81_97f;  // Float values max decimal upto 4 digits
        System.out.println(num5);

        double num6 = 93814526458946523948.9817435237857;   // Double values max decimals upto 13 digits
        System.out.println(num6);   // default decimals are double type

        char num7 = 'a';
        num7++;
        System.out.println(num7);


        System.out.println("\'");
        System.out.println("\"");
        System.out.println("\\");
        System.out.println("\b");
        System.out.println("\f");
        System.out.println("\n");
        System.out.println("\r");
        System.out.println("\t");



    }

}
