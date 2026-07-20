package multithreading;


public class TickTuck {
    public static void main(String[] args) {
        Runnable tick = () -> System.out.println("Tick!");
        Runnable tuck = () -> System.out.println("Tuck!");

        var thread = new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                tick.run();
                try {
                    Thread.sleep(5000); // state = TIMED_WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            tuck.run();
        });

        thread.start();
    }
}
