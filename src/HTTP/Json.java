package HTTP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json {
    public static void main(String[] args) {
        Person p1 = new Person("Roman", 19, 180);
        Gson gson = new Gson(); //Gson gson = new GsonBuilder().create();
        String json1 = gson.toJson(p1); //serialization
        System.out.println(json1); // {"name":"Roman","age":19,"height":180}

        String json2 = "{\"name\":\"Roman\",\"age\":19,\"height\":180}";
        Person p2 = gson.fromJson(json2, Person.class); //deserialization
        System.out.println(p2);


    }
}

class Person {
    String name;
    int age;
    int height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}