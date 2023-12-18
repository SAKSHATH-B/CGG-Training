package sol;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamOperationsExercise {

  public static List<Player> Players = new ArrayList<>();

  public static void displayPlayers() {
    Players.stream().forEach(e -> System.out.println(e.getPlayerName()));
  }

  public static void displayPlayersForCountry(String country) {
    Players
      .stream()
      .filter(e -> e.getHighestScore() > 100 && e.getCountry().equals(country))
      .forEach(e -> System.out.println(e.getPlayerName()));
  }

  public static LinkedList<String> getPlayerNames() {
    LinkedList<String> l1 = Players
      .stream()
      .filter(e -> e.getRuns() > 5000)
      .map(e -> e.getPlayerName())
      .collect(Collectors.toCollection(LinkedList::new));
    return l1;
  }

  public static double getAverageRunsByCountry(String country) {
    double i = Players
      .stream()
      .filter(e -> e.getCountry().equals(country))
      .mapToInt(e -> e.getRuns())
      .average()
      .getAsDouble();
    return i;
  }

  public static List<String> getPlayerNamesSorted() {
    return Players
      .stream()
      .sorted(
        Comparator
          .comparing(Player::getPlayerName)
          .reversed()
          .thenComparing(e -> e.getMatchesPlayed(), Comparator.reverseOrder())
      )
      .map(e -> e.getPlayerName())
      .collect(Collectors.toList());
  }

  public static Optional<Player> getMaxRunsPlayer() {
    return Players.stream().max(Comparator.comparing(Player::getRuns));
  }

  public static Optional<Player> findPlayer(String name, String country) {
    return Players
      .stream()
      .filter(e ->
        e.getPlayerName().equals(name) && e.getCountry().equals(country)
      )
      .findFirst();
  }

  public static boolean checkHighScorerByCountry(String country) {
    return Players
      .stream()
      .anyMatch(e -> e.getCountry().equals(country) && e.getRuns() > 1000);
  }

  public static Map<String, String> getPlayerCountry() {
    return Players
      .stream()
      .filter(e -> e.getMatchesPlayed() > 200)
      .collect(Collectors.toMap(Player::getPlayerName, Player::getCountry));
  }

  static {
    Players.add(new Player("jhon", 1, 1, 1, "usa"));
    Players.add(new Player("wick", 2, 2, 2, "ind"));
    Players.add(new Player("rony", 3, 3, 3, "uk"));
    Players.add(new Player("hunter", 3, 1000, 201, "uk"));
    Players.add(new Player("harry", 5, 3, 300, "ireland"));
    Players.add(new Player("kohli", 50, 6000, 300, "ind"));
    Players.add(new Player("sachin", 50, 7000, 400, "ind"));
  }

  public static void main(String[] args) {
    StreamOperationsExercise.displayPlayersForCountry("uk");
    System.out.println("----------------");
    StreamOperationsExercise.displayPlayers();

    System.out.println(StreamOperationsExercise.checkHighScorerByCountry("uk"));
  }
}
