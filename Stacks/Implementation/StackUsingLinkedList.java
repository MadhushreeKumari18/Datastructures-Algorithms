package Stacks.Implementation;

public class StackUsingLinkedList {

    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    int top;

    StackUsingLinkedList(){
        this.head = null;
        this.top = -1;
    }

    public void push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        ++top;
    }

    public int pop() throws Exception{
        if(top == -1){
            throw new Exception("Stacks.Implementation.Stack is empty");
        }
        Node current = head;
        head = head.next;
        current.next = null;
        top--;
        return current.data;
    }

    public static void main(String args[]) throws Exception{
        StackUsingLinkedList obj = new StackUsingLinkedList();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        while(obj.top >=0){
            System.out.println(obj.pop());
        }
    }
}

/*
Output:
40
30
20
10
* */