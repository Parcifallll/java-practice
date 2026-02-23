package functional_programming;

import java.util.function.*;

public class FunctionUtils {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<>() { //returns nothing, just consume. <T> -> void
            @Override
            public void accept(String string) {
                System.out.printf("Consumed string \"%s\"...", string);
            }
        };

        Supplier<Integer> supplier = new Supplier<Integer>() { //takes nothing, only deliver. <> -> <T>
            @Override
            public Integer get() {
                return 10;
            }
        };

        Function<Character, Integer> function = new Function<>() { //f: T->R
            @Override
            public Integer apply(Character ch) {
                return Integer.parseInt(ch.toString());
            }
        };

        Predicate<String> predicate = new Predicate<>() { //checker. <T> -> Boolean
            @Override
            public boolean test(String string) {
                return string.endsWith("z");
            }
        };


        consumer.accept("PUBG");
        supplier.get();
        function.apply('6');
        predicate.test("aaaz");
    }
}
