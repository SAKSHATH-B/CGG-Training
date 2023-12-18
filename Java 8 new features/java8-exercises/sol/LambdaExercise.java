package sol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaExercise {

  public static List<String> countries = new ArrayList<>();
  public static Map<String, String> countryCapitals = new HashMap<>();

  static {
    countries.add("usa");
    countries.add("ind");
    countries.add("africa");
    countries.add("america");
    countryCapitals.put("usa", "newyork");
    countryCapitals.put("ind", "delhi");
    countryCapitals.put("africa", "cairo");
  }

  public static void displayCountries() {
    countries.forEach(System.out::println);
  }

  public static void displayCountryCapitals() {
    countryCapitals.forEach((key, val) -> System.out.println(key + "---" + val)
    );
  }

  public static void sortCountriesByName() {
    // Collections.sort(countries, Collections.reverseOrder());
    countries.sort((a, b) -> b.compareTo(a));
  }

  public static void sortCountriesBylength() {
    countries.sort((a, b) -> b.length() > a.length() ? b.length() : a.length());
  }

  public static void removeCountry() {
    countries.removeIf(s -> s.length() > 6);
  }

  public static void main(String[] args) {
    // LambdaExercise.removeCountry();
    LambdaExercise.displayCountries();
  }
}
