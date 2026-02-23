package miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class New_switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> charCount = new HashMap<>();
        charCount.put("A, B, C", 0);
        charCount.put("0, 1", 0);
        charCount.put("#, %", 0);
        for (char ch : input.toCharArray()) {
            switch (ch) {
                case 'A', 'B', 'C' -> charCount.put("A, B, C", charCount.get("A, B, C") + 1); //many values in one case
                case '0', '1' -> charCount.put("0, 1", charCount.get("0, 1") + 1);
                default -> charCount.put("#, %", charCount.get("#, %") + 1);
            }
        }
    }
}