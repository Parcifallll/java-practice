package dsa.project_practicum_contest;

import java.util.*;

// N - кол-во вставок (L или R). L - вставить число i слева от числа i-1. R - вставить число i справа от числа i-1.
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();

        // RRLLRR for i=1,2,...,n

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(n); // n = 6, добавим последнее число в пустой дек
        for (int i = n - 1; i >= 0; i--) { // i from [5, 0]. Будем добавлять элементы в дек с конца
            char c = str.charAt(i);
            if (c == 'R') deque.addFirst(i); // [i-1] [i]
            else deque.addLast(i); // [i] [i-1]
        }

        for (int x : deque) {
            // 0 1 4 5 6 3 2
            System.out.print(x + " ");
        }
    }
}
