package cgg.map;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapExample {

  public static void main(String[] args) {
    List<String> uris = new ArrayList<>();

    uris.add("C:\\MyFile1.txt");
    uris.add("D:\\MyFile2.txt");
    uris.add("C:\\MyFile3.txt");

    Stream<Path> map = uris.stream().map(uri -> Paths.get(uri));
    map.forEach(System.out::println);

    System.out.println("----------------------------------");

    List<Detail> details = new ArrayList<>();

    List<String> parts1 = new ArrayList<>();
    parts1.add("Parts_1");
    parts1.add("Parts_2");
    parts1.add("Parts_3");

    List<String> parts2 = new ArrayList<>();
    parts2.add("Parts_1");
    parts2.add("Parts_2");
    parts2.add("Parts_3");
    parts2.add("Parts_4");

    Detail detail1 = new Detail(1001, parts1);
    Detail detail2 = new Detail(1002, parts2);

    details.add(detail1);
    details.add(detail2);

    Stream<String> flatMapStream = details
      .stream()
      .flatMap(d -> d.getDetails().stream());
    flatMapStream.forEach(System.out::println);
  }
}
