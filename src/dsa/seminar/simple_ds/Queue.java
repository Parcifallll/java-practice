package dsa.seminar.simple_ds;

import java.util.Stack;

// implement via stack only
public class Queue<T> {
    private Stack<T> inStack;
    private Stack<T> outStack;

    public Queue(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(T x){
        inStack.push(x);
    }

    public void popLeft(){
        while (!inStack.isEmpty()){
            T pop = inStack.pop();

        }
    }
}
