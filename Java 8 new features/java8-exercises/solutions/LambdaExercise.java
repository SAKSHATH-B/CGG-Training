package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaExercise {

  public static List<String> countries = new ArrayList<>();
  public static Map<String, String> countryCapitals = new HashMap<>();

  static {
    countries.add("India");
    countries.add("Australia");
    countries.add("America");

    countryCapitals.put("India", "Delhi");
    countryCapitals.put("America", "NewYork");
    countryCapitals.put("Australia", "Sydney");
  }

  public static void displayCountries() {
    countries.forEach(System.out::println);
  }

  public static void displayCountryCapitals() {
    countryCapitals.forEach((k, v) -> System.out.println(k + "-" + v));
  }

  public static void sortCountriesByName() {
    countries.sort((s1, s2) -> s1.compareTo(s2));
    System.out.println(countries);
  }

  public static void sortCountriesBylength() {
    countries.sort((s1, s2) ->
      s2.length() > s1.length() ? s2.length() : s1.length()
    );
    System.out.println(countries);
  }

  public static void removeCountry() {
    countries.removeIf(s1 -> s1.length() > 6);
    System.out.println(countries);
  }

  public static void main(String[] args) {
    // LambdaExercise.displayCountries();
    // LambdaExercise.displayCountryCapitals();
    // LambdaExercise.sortCountriesByName();
    // LambdaExercise.sortCountriesBylength();
    LambdaExercise.removeCountry();
  }
}
