import java.util.Stack;

public class Queue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    Queue(){
        this.st1 = new Stack<Integer>();
        this.st2 = new Stack<Integer>();
    }

    public void enqueue(int n){
        st1.push(n);
    }

    public int dequeue(){
        if(st1.isEmpty() && st2.isEmpty()){
            System.out.print("Queue is empty");
            return -1;
        }
        else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            int result = st2.pop();
            //doing the below while for further enqueue operations
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }
        return result;
    }

    public boolean isEmpty(){
        return st1.isEmpty() && st2.isEmpty();
    }

    public static void main(String args[]){
        Queue obj = new Queue();
        obj.enqueue(100);
        obj.enqueue(200);
        obj.enqueue(300);
        obj.enqueue(400);
        obj.enqueue(500);
        obj.enqueue(600);
        while(!obj.isEmpty()){
            System.out.println(obj.dequeue());
        }
        //System.out.println(obj.dequeue());
    }
}