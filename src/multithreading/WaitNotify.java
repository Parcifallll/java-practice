package multithreading;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class WaitNotify {
    public static void main(String[] args) {

        // monitor
        final Queue<Double> queue = new ArrayDeque<>();

        Thread producer = new Thread(() -> {
            synchronized (queue) {
                System.out.println("Producer: add to queue");
                queue.add(Math.random());
                queue.notify(); // notify consumer
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Consumer is waiting notify()");
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Consumer interrupted");
                        return;
                    }
                }
                System.out.println("Consumer removed " + queue.remove());
            }
        });

        consumer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        producer.start();
    }
}


