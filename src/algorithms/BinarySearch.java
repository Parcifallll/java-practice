package algorithms;

import java.util.Arrays;

public class BinarySearch {
    public static <T extends Comparable<T>> int binarySearchIterative(T val, T[] vals) {
        int low = 0;
        int high = vals.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2; //or (high + low) >>> 1 (Overflow check)
            if (vals[mid] == val) return mid;
            else if (vals[mid].compareTo(val) > 0) high = mid - 1;
            else if (vals[mid].compareTo(val) < 0) low = mid + 1;
        }
        return -1 + (low);
    }

    public static <T extends Comparable<T>> int binarySearchRecursive(T val, T[] vals, int low, int high) {
        int mid = low + (high - low) / 2; //(high + low) >>> 1
        if (vals[mid].compareTo(val) > 0) return binarySearchRecursive(val, vals, low, mid - 1);
        else if (vals[mid].compareTo(val) < 0) return binarySearchRecursive(val, vals, mid + 1, high);
        return mid;
    }

    public static void main(String[] args) {
        
        Integer[] vals = {1, 3, 4, 5, 6, 9, 10, 11, 12, 14};
        Integer val = 12;

        Arrays.binarySearch(vals, val);
        System.out.println(binarySearchIterative("abc", new String[]{"abb", "abc"}));
        System.out.println(binarySearchRecursive(val, vals, 0, vals.length - 1));
    }
}
