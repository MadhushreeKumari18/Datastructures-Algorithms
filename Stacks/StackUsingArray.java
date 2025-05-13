package Stacks.Implementation;

import java.util.Arrays;

public class Stack {

    int size;
    int top;
    int[] arr;

    Stack(int number){
        this.size= number;
        arr = new int[number];
        top=-1;
    }

    public void push(int n) throws Exception{
        if(isFull()){
            throw new Exception("Stacks.Implementation.Stack is full.");
        }
        arr[++top]= n;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stacks.Implementation.Stack is empty.");
        }
        return arr[top--];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == (size -1));
    }

    @Override
    public String toString() {
        return "Stacks.Implementation.Stack " + Arrays.toString(arr);
    }

    public static void main(String args[]) throws Exception{
        Stack st = new Stack(5);
        st.push(30);
        st.push(20);
        st.push(10);
        st.push(40);
        st.push(50);
        System.out.println(st);
        st.push(100);
//        while(!st.isEmpty()){
//            System.out.println(st.pop());
//        }
    }
}

/*
Output:

Stacks.Implementation.Stack [30, 20, 10, 40, 50]
Exception in thread "main" java.lang.Exception: Stacks.Implementation.Stack is full.
	at Stacks.Implementation.Stack.push(1. StackUsingArray.java:17)
	at Stacks.Implementation.Stack.main(1. StackUsingArray.java:50)

*/