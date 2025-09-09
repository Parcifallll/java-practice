package CollectionsFramework;

import java.util.*;

abstract class DataStructures {
    public void Map(){
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.get('A');
        map.getOrDefault('A', 1);
        map.remove('A');
        map.containsKey('A');
        map.containsValue(1);
    }

    public void Stack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.peek();
        stack.pop();
        stack.isEmpty();
    }

    public void List(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.remove(1);
        list.contains(1);
        list.get(0);
    }

    public void Queue() {
        Deque<Integer> dequeue = new ArrayDeque<>();
        dequeue.add(1);
        dequeue.remove();
        dequeue.getFirst();
    }

    public void String(){
        StringBuilder sb = new StringBuilder();
        String s = "";
        s = new StringBuilder(s).reverse().toString(); //all operations cost O(n)
    }

}