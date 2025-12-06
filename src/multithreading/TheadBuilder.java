package multithreading;

// modern way (Java 21+) to create Thread
public class TheadBuilder {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println(Thread.currentThread().getName());

        Thread thread = Thread.ofPlatform()
                .name("platform-thread")
                .daemon(false)
                .start(task);
        Thread daemon = Thread.ofPlatform() // JVM does not wait for this thread
                .name("daemon-thread")
                .daemon()
                .priority(10)
                .start(task);

        Thread virtual = Thread.ofVirtual()
                .name("virtual-thread")
                .start(task);


        daemon.join();
        virtual.join(); // virtual is daemon by default, JVM won't wait for it
    }
}