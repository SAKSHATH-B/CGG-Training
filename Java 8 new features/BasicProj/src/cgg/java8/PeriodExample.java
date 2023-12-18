package cgg.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodExample {
	public static void main(String[] args) {
		LocalDate initialDate = LocalDate.now();
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));
	    int days = Period.between(initialDate, finalDate).getDays();
	    System.out.println(days);
	    
	    long between = ChronoUnit.DAYS.between(initialDate, finalDate);
	    System.out.println(between);
	    
	    System.out.println("-----------------------------");
	    LocalTime initialTime = LocalTime.of(6, 30,0);
	    LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
	    long seconds = Duration.between(initialTime, finalTime).getSeconds();
	    System.out.println(seconds);
	    
	    long between2 = ChronoUnit.SECONDS.between(initialTime, finalTime);
	    System.out.println(between2);
	    
	    System.out.println("-------------------------------");
	    LocalDate today = LocalDate.now();
	    LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);
	    Period p = Period.between(today, birthday);
	    long p2 = ChronoUnit.DAYS.between(today, birthday);
	    System.out.println("You are "+p.getYears()+" years, "+p.getMonths()+" months, and "+
	     p.getDays()+" old. ( "+p2+ " days total)");
	    
	    //to calculate next birthday
	    
	    LocalDate nextBDay = birthday.withYear(today.getYear());
	    //if your birthday has occurred this year already, add 1 to the year
	    if(nextBDay.isBefore(today)||nextBDay.isEqual(today)) {
	    	nextBDay = nextBDay.plusYears(1);
	    }
	    
	    p=Period.between(today, nextBDay);
	    p2=ChronoUnit.DAYS.between(today, nextBDay);
	    System.out.println("There are "+p.getMonths()+" months, and "+
	   	     p.getDays()+" days until your next birthday. ( "+p2+ " total)");
	    
	    
	}
	

}
