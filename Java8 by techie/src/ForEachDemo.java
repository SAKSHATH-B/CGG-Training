import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * ForEachDemo
 */
public class ForEachDemo {

  //filter --> conditional check

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("ArjunReddy");
    list.add("Animal");
    list.add("Guntur karam");
    list.add("Businessman");
    list.add("Banglore Days");

    list
      .stream()
      .filter(i -> i.startsWith("A"))
      .forEach(t -> System.out.println(t));

    Map<Integer, String> map = new HashMap<>();
    map.put(1, "ab");
    map.put(2, "cd");
    map.put(3, "ef");
    map.put(4, "gh");
    // map.forEach((key, value) -> System.out.println(key + " : " + value));        //-- general method
    map
      .entrySet()
      .stream()
      .filter(i -> i.getKey() % 2 == 0)
      .forEach(obj -> System.out.println(obj)); //-- using stream
    // Consumer<String> consumer = t -> System.out.println(t);
    // for (String s : list) {
    //   consumer.accept(s);
    // }
  }
}
