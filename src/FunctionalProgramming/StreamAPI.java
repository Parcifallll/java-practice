package FunctionalProgramming;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        Stream<String> stream_1 = Stream.of("first way");

        List<String> list = new ArrayList<>(List.of("second way"));
        Stream<String> stream_2 = list.stream();
        boolean containsEl = stream_1.allMatch((element) -> (element.equals("first way")));

        List<Integer> lst = Stream.of(1, 2, 3, 4).collect(Collectors.toList());

        Stream.of("q", "ww", "w", "22").filter((str) -> (str.length() != 1)).toList().forEach(System.out::println);

        Map<Character, Integer> map = new HashMap<>(Map.of('A', 1, 'B', 2, 'C', 3));
        //map.forEach((key, value) -> map.remove(key));  fail-fast operator

        map.entrySet().stream().filter(entry -> (entry.getKey() > 'A')).forEach(System.out::println);
//        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator(); //standard approach
//        while (iterator.hasNext()) {
//            Map.Entry<Character, Integer> entry = iterator.next();
//            char key = entry.getKey();
//            int value = entry.getValue();
//            if (key > 'A') iterator.remove();
//        }
//        map.forEach((key, value) -> System.out.println(key + ": " + value));
        Map<Character, Integer> map2 = new HashMap<>(Map.of('A', 1, 'B', 2));
        Stream.of('A', 'C', 'B').map(map2::get).forEach(System.out::println); //prints map2 VALUES
        List<Integer> list2 = List.of(1, 2, 3, 4 );
        list2.stream().map(n -> n*2).forEach(n -> System.out.printf("%d ", n));
    }
}
