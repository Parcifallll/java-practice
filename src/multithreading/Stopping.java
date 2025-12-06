package multithreading;

public class Stopping {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("tick");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // obligatory !!!!
                    System.out.println(Thread.currentThread().getState());
                    System.out.println("thread is stopped after interrupt()");
                    System.out.println(Thread.currentThread().getState());
                    return;
                }
            }
        });

        System.out.println("main: before thread.start()");
        thread.start();

        Thread.sleep(5000);        // main sleeps for 5 sec -> give time for thread to work
        System.out.println("main: sending interrupt...");
        thread.interrupt(); // interrupt thread

        thread.join();              // main waits until thread is correctly interrupted
        System.out.println("main(): finished");
        System.out.println(Thread.currentThread().getState());
    }
}