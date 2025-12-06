package multithreading;

public class Sync {
    private static final int N = 100_000_000;
    private static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object(); // only for objects (not needed for primitives)

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                synchronized (monitor) {
                    x++;
                }
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                synchronized (monitor) {
                    x--;
                }
            }
        });

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println("x = " + x);
    }
}