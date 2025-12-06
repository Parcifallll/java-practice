package multithreading;

import java.util.ArrayList;
import java.util.List;

public class Thread_practice {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("thread");
        for (int i = 0; i < 1_000; i++) {
            int finalI = i;
            new Thread(() -> System.out.println("thread: " + finalI)).start();

            // не подряд короче
        }
        System.exit(0);

    }
}
