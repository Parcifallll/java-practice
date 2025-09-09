package FunctionalProgramming;


import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class LambdaPractice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "ab", "abcd", "abc", "abc", "abbbd"));
        // 1
        list.forEach((s1) -> {
                    if (s1.length() > 1) System.out.println(s1);
                }
        );

        //2
        list.forEach( (s1) -> System.out.println(s1.toUpperCase()));

        //standard approach VS without creating new Comparator
        List<Person> people = new ArrayList<>(List.of(new Person ("Alice", 10), new Person ("Bob", 20)));
        Comparator<Person> byAge = Comparator.comparing(Person::getName);
        people.sort(byAge);

        people.sort(Comparator.comparing(Person::getName));

    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
    }

    public String getName () {
        return name;
    }
}