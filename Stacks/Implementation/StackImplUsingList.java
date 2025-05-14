package Stacks.Implementation;

import java.util.ArrayList;

public class StackImpl {

    ArrayList<Integer> arrList;
    int top;

    StackImpl(){
        this.arrList = new ArrayList<Integer>();
        this.top = -1;
    }

    public void push(int element){
        arrList.add(element);
        top++;
    }

    public int pop() throws Exception{
        if(isStackEmpty())
            throw new Exception("Stacks.Implementation.Stack is empty");
        else
            return arrList.remove(top--);
    }

    public boolean isStackEmpty(){
        return top == -1;
    }

    @Override
    public String toString() {
        return "Stacks.Implementation.Stack : " + arrList;
    }

    public static void main(String args[]) throws Exception{
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
Stack : [100, 200]
Stack : [100, 200, 300]
Stack : [100, 200, 300, 400]
Stack : [100, 200, 300, 400, 500]
Stack : [100, 200, 300, 400]
Stack : [100, 200, 300]
Stack : [100, 200]
Stack : [100]
Stack : []
Exception in thread "main" java.lang.Exception: Stack is empty
at Stacks.StackImpl.pop(StackImpl.java:22)
at Stacks.StackDemo.main(StackDemo.java:27)