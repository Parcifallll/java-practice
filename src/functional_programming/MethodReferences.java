package functional_programming;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;

public class MethodReferences {
    public static void main(String[] args) {
        // 1 - with static methods of the class
        String a = "First";
        String b = "Second";
        BiPredicate<String, String> methodReference = Objects::equals; //reference
        BiPredicate<String, String> lambda = (s1, s2) -> Objects.equals(a, b); //lambda
        methodReference.test(a, b);
        lambda.test(a, b);

        // 2 - with methods of the object
        List<String> list = new ArrayList<>(List.of("1", "2", "3")); // concrete object "list"
        Predicate<String> predicate_1 = list::contains;
        Predicate<String> predicate_2 = (lst) -> list.contains(lst);

        // 3 - with constructors (same code volume)

        // 4 - Collections
        List<Integer> lst = new ArrayList<>(List.of(1, 2, 3, 4));
        lst.forEach(element -> System.out.println(element));
        lst.forEach(System.out::println); //reference to static method

        lst.removeIf(el -> el.equals(1));
        lst.removeIf(Integer.valueOf(1)::equals);

    }
}

class Table {
    private int height;
    private int length;
    private int volume;

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    Comparator<Table> byH = Comparator.comparingInt(Table::getHeight)
            .thenComparing(Table::getLength); //reference to class's method

}
