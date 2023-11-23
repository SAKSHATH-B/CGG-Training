package LabPrograms;

public class Lab_1_9 {
    public static String StringManipulation(String str, int i){
        switch(i) {
            case 1:
                return str+str;
            case 2:
                char[] ch = str.toCharArray();
                for(i=0 ; i<ch.length ; i++){
                    if(i%2!=0){
                        ch[i] = '#';
                    }
                }
                return new String(ch);
            case 3:
                StringBuilder stbr = new StringBuilder();
                char[] stb = str.toCharArray();
                for(char c : stb){
                    if(stbr.indexOf(String.valueOf(c)) == -1){
                        stbr.append(c);
                    }
                }
                return stbr.toString();
            case 4:
                char[] a = str.toCharArray();
                for(i=0 ; i<a.length ; i++){
                    if(i%2!=0){
                        a[i] = Character.toUpperCase(a[i]);
                    }
                }
                return new String(a);
            default:
                return "Invalid Choice";
        }
    }

    public static void main(String[] args) {
        String input = "Hello";
        int choice = 3;

        String result = StringManipulation(input,choice);
        System.out.println("Result : "+result);
    }
}
