package collections_framework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorInterface {
    public static void main(String[] args) {
        List<Person> list =
                new ArrayList<>(List.of(new Person(10, "P1"), new Person(10, "P2")));
        list.sort(new AgeComparator().reversed());
        //Collections.sort(list, new AgeComparator().reversed());
        Comparator<Person> ageComp = Comparator.comparingInt(Person::getAge); //link to the getter-method
        Comparator<Person> nameComp = Comparator.comparing(person -> person.getName()); //bad encapsulation
        Comparator<Person> specComp = Comparator.comparingInt(Person::getAge).thenComparing(Person::getName);
    }
}


class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}


