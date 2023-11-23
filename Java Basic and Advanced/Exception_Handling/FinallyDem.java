public class FinallyDem {
    static void ProcA(){
        try {
            System.out.println("Inside procA");
            throw new RuntimeException();
        }
        // catch(Exception e){
        //     System.out.println("Inside Catch of ProcA");
        // }
         finally{
            System.out.println("ProcA finally");
        }
    }    
    
    static void ProcB(){
        try {
            System.out.println("Inside PRocB");
        } finally{
            System.out.println("ProcB finally");
        }
    }
    
    static void ProcC(){
        try {
            System.out.println("Inside ProcC");
        } finally{
            System.out.println("Proc C finally");
        }
    }

    
public static void main(String[] args) {
    try{
        ProcA();

    }catch(Exception e){System.out.println("Exception Caught");}
    ProcB();
    ProcC();
}
}
