package collections_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableInterface {
    public static void main(String[] args) {
        Person p1 = new Person(10, "asd");
        Person p2 = new Person(11, "asd");
        List<Person> list = new ArrayList<>(List.of(p1, p2));
        System.out.println(p1.compareTo(p2));
        Collections.sort(list);
        Person oldest = Collections.max(list); // uses compareTo
    }
}

class Person implements Comparable<Person> {
    private int age;
    //for int and Integer ALWAYS use Integer.compare, because of overflow and null
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person person) {
        //if ages are equal, compare alphabetically by names
        int cmp = Integer.compare(this.age, person.age);
        if (cmp == 0) {
            return this.name.compareTo(person.name);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "ColectionsFramework.Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
