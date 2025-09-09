package CollectionsFramework;

import java.util.*;


public class Lists {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3); //unmodifiable
        List<Integer> list1 = List.of(1, 2, 3); //unmodifiable
        //list.set(2, 4); //we can only replace any element, but can't add
        // list1.add(4); //Immutable object is modified

        Integer[] array = list.toArray(new Integer[0]);
        // better that [list.(size)], JVM automatically allocate memory

        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3)); //mutable
        for(int el : list2){
            System.out.println(el); //we do not modify the list, it's OK
            list.remove(el); //ConcurrentModificationException from the second el
        }

        Iterator<Integer> iterator = list2.iterator(); //create Iterator as a variable!
        while (iterator.hasNext()){
            Integer el = iterator.next();
            if (el.equals(1)){
                iterator.remove();
            }
        }
    }
}
