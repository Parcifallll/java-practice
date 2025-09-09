package FunctionalProgramming;

import java.util.*;
import java.util.stream.*;

public class StreamPractice {
    public static void main(String[] args) {
        //--1--
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        list1.stream().map(n -> n*2);

        //--2--
        List<String> strings = List.of("Apple", "Banana", "Avocado", "Cherry");
        strings.stream().filter(n -> n.charAt(0) == 'A').forEach(System.out::println);

        //--3--
        List<Integer> list3 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list3.stream().filter(n -> n % 2 == 0).count();

        //--4--
        List<String> list4 = List.of("Java", "Stream", "Lambda", "Function");
        List<Integer> newList4 = list4.stream().map(String::length).collect(Collectors.toList());
        //After Java 16 -> map(String::length).toList();

        //--5--
        List<String> list5 = List.of("Java", "C", "Python", "JS", "Ruby");
        List<String> newList5 = list5.stream().filter(str -> str.length() > 3).toList();

        //--6--
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        boolean bool = numbers.stream().allMatch(n -> n > 0);
        System.out.println(bool);

        //--7--
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);
        map.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()*2).forEach(System.out::println);

    }
}
