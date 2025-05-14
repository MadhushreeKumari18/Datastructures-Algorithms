import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {

    Queue<Integer> q1;
    Queue<Integer> q2;

    StackUsing2Queue(){
        this.q1 = new LinkedList<Integer>();
        this.q2 = new LinkedList<Integer>();
    }

    public void push(int data){
        if(q1.size() == 0){
            q1.add(data);
        }
        else {
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            q1.add(data);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stacks.Implementation.Stack is empty");
        }
        return q1.remove();
    }

    public boolean isEmpty() {
        return (q1.size() == 0);
    }
}