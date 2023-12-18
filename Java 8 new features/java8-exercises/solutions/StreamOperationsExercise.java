package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsExercise {

  public static List<Player> players = new ArrayList<>();

  static {
    players.add(new Player("jhon", 1, 1, 1, "usa"));
    players.add(new Player("wick", 2, 2, 2, "ind"));
    players.add(new Player("rony", 3, 3, 3, "uk"));
    players.add(new Player("hunter", 3, 1000, 201, "uk"));
    players.add(new Player("harry", 5, 3, 300, "ireland"));
    players.add(new Player("kohli", 50, 6000, 300, "ind"));
    players.add(new Player("sachin", 50, 7000, 400, "ind"));
    players.add(new Player("rohit", 250, 7000, 400, "ind"));
  }

  public static void displayPlayers() {
    players.stream().forEach(s -> System.out.println(s.getPlayerName()));
  }

  public static void displayPlayersForCountry(String con) {
    players
      .stream()
      .filter(s -> s.getHighestScore() > 100 && s.getCountry().equals(con))
      .forEach(s -> System.out.println(s.getPlayerName()));
  }

  public static LinkedList<String> getPlayerNames() {
    LinkedList<String> res1 = players
      .stream()
      .filter(s -> s.getRuns() > 5000)
      .map(p -> p.getPlayerName())
      //   .sorted((p1, p2) -> p2.getPlayerName().compareTo(p1.getPlayerName()))
      .collect(Collectors.toCollection(LinkedList::new));

    return res1;
  }

  public static double getAverageRunsByCountry(String country) {
    double res2 = players
      .stream()
      .filter(p -> p.getCountry().equals(country))
      .mapToInt(s -> s.getRuns())
      .average()
      .getAsDouble();
    return res2;
  }

  public static List<String> getPlayerNamesSorted() {
    List<String> res3 = players
      .stream()
      .sorted(
        Comparator
          .comparing(Player::getPlayerName)
          .reversed()
          .thenComparing(s -> s.getMatchesPlayed(), Comparator.reverseOrder())
      )
      .map(s -> s.getPlayerName())
      .collect(Collectors.toList());

    return res3;
  }

  public static Map<String, String> getPlayerCountry() {
    return players
      .stream()
      .filter(s -> s.getMatchesPlayed() > 200)
      .collect(Collectors.toMap(Player::getPlayerName, Player::getCountry));
  }

  public static Optional<Player> getMaxRunsPlayer() {
    return players.stream().max(Comparator.comparingInt(Player::getRuns));
  }

  public static Optional<Player> findPlayer(String name, String country) {
    return players
      .stream()
      .filter(e ->
        e.getPlayerName().equals(name) && e.getCountry().equals(country)
      )
      .findFirst();
  }

  public static boolean checkHighScorerByCountry(String country) {
    return players
      .stream()
      .anyMatch(e -> e.getCountry().equals(country) && e.getRuns() > 10000);
  }

  public static void main(String[] args) {
    // StreamOperationsExercise.displayPlayers();
    // StreamOperationsExercise.displayPlayersForCountry("ind");

    // LinkedList<String> playerNames = StreamOperationsExercise.getPlayerNames();
    // System.out.println(playerNames);

    // double averageRunsByCountry = StreamOperationsExercise.getAverageRunsByCountry(
    //   "ind"
    // );
    // System.out.println(averageRunsByCountry);

    // List<String> playerNamesSorted = StreamOperationsExercise.getPlayerNamesSorted();
    // System.out.println(playerNamesSorted);

    // Map<String, String> playerCountry = StreamOperationsExercise.getPlayerCountry();
    // System.out.println(playerCountry);

    Optional<Player> maxRunsPlayer = StreamOperationsExercise.getMaxRunsPlayer();
    if (maxRunsPlayer.isPresent()) {
      Player pl = maxRunsPlayer.get();
      System.out.println(pl.getRuns());
    }
    // Optional<Player> player = StreamOperationsExercise.findPlayer(
    //   "rohit",
    //   "ind"
    // );
    // System.out.println(player.get());

    // boolean checkHighScorerByCountry = StreamOperationsExercise.checkHighScorerByCountry(
    //   "ind"
    // );
    // System.out.println(checkHighScorerByCountry);
  }
}
