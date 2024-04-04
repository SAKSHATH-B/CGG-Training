
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Program11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sa=sc.nextLine();

        
       DateTimeFormatter a= DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate d=LocalDate.parse(sa,a);


       

       System.out.println(a.format(d));

    //    LocalDate currentDate = LocalDate.now();
     

    //         Period period = Period.between(d, currentDate);

    //         int years = period.getYears();
    //         int months = period.getMonths();
    //         int days = period.getDays();

    //         System.out.println("Duration:");
    //         System.out.println("Years: " + years);
    //         System.out.println("Months: " + months);
    //         System.out.println("Days: " + days);



    LocalDate curr=LocalDate.now();
    Period p=Period.between(d, curr);
    int years=p.getYears();
    int months=p.getMonths();
    int days=p.getDays();
    System.out.println(years+"-years-"+ months+"-months-"+days+"-days-");
    }
}
