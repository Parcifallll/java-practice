package algorithms;

public class ProgramDuration {
    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        for(long i = 0; i < 100_000_00000L; i++);
        end = System.currentTimeMillis();
        System.out.println(end - start); //milliseconds
    }
}
