package map;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapEx {

  public static void main(String[] args) {
    List<String> uri = new ArrayList<>();
    uri.add("C:\\File1.txt");
    uri.add("D:\\File2.txt");
    uri.add("C:\\File3.txt");
    uri.add("C:\\File4.txt");

    // Stream<Path> map = uri.stream().map(s -> Paths.get(s));
    Stream<Path> map = uri.stream().map(Paths::get);
    map.forEach(System.out::println);

    System.out.println("________________________");

    List<DetailEx> details = new ArrayList<>();

    List<String> parts1 = new ArrayList<>();
    parts1.add("Parts_1");
    parts1.add("Parts_2");
    parts1.add("Parts_3");

    List<String> parts2 = new ArrayList<>();
    parts2.add("Parts_1");
    parts2.add("Parts_2");
    parts2.add("Parts_3");
    parts2.add("Parts_4");

    DetailEx detail1 = new DetailEx(1001, parts1);
    DetailEx detail2 = new DetailEx(1001, parts2);

    details.add(detail1);
    details.add(detail2);

    Stream<String> flatMapStream = details
      .stream()
      .flatMap(d -> d.getDetails().stream());
    flatMapStream.forEach(System.out::println);
  }
}
