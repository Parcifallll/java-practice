package algorithms;

import java.util.*;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();
        int[] scores = new int[size];
        for (int i = 0; i < size; i++) {
            scores[i] = sc.nextInt();
        }

        List<List<Integer>> seq = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            seq.add(new ArrayList<>(Collections.singletonList(scores[i])));
        }

        int maxLen = 1, bestIndex = 0;

        for (int cur = 1; cur < size; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                if (scores[prev] <= scores[cur]) {
                    List<Integer> prob = new ArrayList<>(seq.get(prev));
                    prob.add(scores[cur]);

                    List<Integer> exst = seq.get(cur);
                    if (prob.size() > exst.size() ||
                            (prob.size() == exst.size() && Compare(prob, exst) < 0)) {
                        seq.set(cur, prob);
                    }
                }
            }

            if (seq.get(cur).size() > maxLen ||
                    (seq.get(cur).size() == maxLen && Compare(seq.get(cur), seq.get(bestIndex)) < 0)) {
                maxLen = seq.get(cur).size();
                bestIndex = cur;
            }
        }

        List<Integer> res = seq.get(bestIndex);
        System.out.print("Best length = " + maxLen + "\nBest combo is: ");
        for (int num : res) {
            System.out.print(" " + num);
        }
        System.out.println();
    }


    private static int Compare(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            int diff = a.get(i) - b.get(i);
            if (diff != 0) return diff;
        }
        return a.size() - b.size();
    }
}
