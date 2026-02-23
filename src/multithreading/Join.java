package multithreading;

import static java.lang.Thread.sleep;

public class Join {
    public static void main(String[] args) { // main thread
        Runnable task = () -> System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        var t1 = new Thread(() -> {
            task.run();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });

        var t2 = new Thread(() -> {
            task.run();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });

        var t3 = new Thread(() -> {
            task.run();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });


        t1.start();
        t2.start();
        t3.start();


    }
}

