public class BasicOne {
    public static void main(String[] args) {
        int n1 = 7;
        // int result = n1++;  // Fetch the value first and assign it to the variable and perform incrementation (POST INCREMENTATION)
        int result = ++n1;  // Fetch the value and preprocess incrementation and assaign it to variable (PRE INCREMENTATION)
        System.out.println(result);


        int a = 1;
        int b = 2;
        double x = 3;
        double y = 4;
        boolean res = a<b && y>=x;
        System.out.println(!res);

        int abs = 1728001;
        String re = abs%2==0 ? "Kia" : "Motors";
        System.out.println(re);

    }
}
