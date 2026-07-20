package dsa.two_pointers;

import java.util.ArrayList;
import java.util.List;

/* Даны два отсортированных по неубыванию массива.
Определить, если ли в них одинаковые числа
 */
public class SameNums {
    public static List<Integer> solve(int[] a, int[] b){
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length){
            if (a[i] == b[j]){
                res.add(a[i]);
                i++;
                j++;
            }
            else if (a[i] > b[j]) j++;
            else i++;
        }
        return res;
    }
}
