package miscellaneous;

public class Chars {
    public static void main(String[] args) {
        int chars = (int) Math.pow(2, (double) Character.BYTES * 8 / 2 - 1);//char = Unicode (2**16 symbols), ASCII (2**7 symbols)
        for (int i = 0; i < chars; i++) {
            System.out.println(i + ": " + (char) i);
        }
    }
}
