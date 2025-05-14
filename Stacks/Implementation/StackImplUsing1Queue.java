package Stacks.Implementation;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackUsingOneQueue {

    Queue<Integer> q;

    public StackUsingOneQueue() {
        q = new LinkedList<Integer>();
    }

    public void push(int data) {
        int size = q.size();
        q.add(data);
        for (int i = 0; i < size; i++) {
            int d = q.remove(); //It wont allow you to use removeLast()
            q.add(d);
        }
    }

    /* Function to remove top element from the stack */
    public int pop() {
        if (q.size() == 0)
            throw new NoSuchElementException("Underflow Exception");
        return q.remove();
    }

    /* Function to check the top element of the stack */
    public int peek() {
        if (q.size() == 0)
            throw new NoSuchElementException("Underflow Exception");
        return q.peek();
    }

    public String toString() {
        return "Stacks.Implementation.Stack : " + queue;
    }

    public static void main(String args[]) throws Exception {
        StackImpl stack = new StackImpl();
        stack.push(100);
        System.out.println(stack);
        stack.push(200);
        System.out.println(stack);
        stack.push(300);
        System.out.println(stack);
        stack.push(400);
        System.out.println(stack);
        stack.push(500);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}


//Result:

Stack : [100]
Stack : [200, 100]
Stack : [300, 200, 100]
Stack : [400, 300, 200, 100]
Stack : [500, 400, 300, 200, 100]
Stack : [400, 300, 200, 100]
Stack : [300, 200, 100]
Stack : [200, 100]
Stack : [100]
Stack : []
Exception in thread "main" java.lang.Exception: Queue is empty
at Stacks.StackImpl.pop(StackImpl.java:30)
at Stacks.StackDemo.main(StackDemo.java:27)