package CollectionsFramework;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder()));
        Comparator<Map<String, Integer>> map1 = Comparator.comparingInt(m -> m.get("1"));
    }
}
