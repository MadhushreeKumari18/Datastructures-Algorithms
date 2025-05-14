import java.util.Stack;

public class QueueReverse {

    Stack<Integer> st;

    QueueReverse(){
        this.st = new Stack<Integer>();
    }

    public void enqueue(int n){
        st.push(n);
    }

    public int dequeue() throws Exception{
        if(isEmptyQ())
            throw new Exception("Queue is empty");
        return st1.pop();
    }

    public boolean isEmptyQ(){
        return st1.isEmpty();
    }

    public static void main(String args[]){
        QueueReverse obj = new QueueReverse();
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.enqueue(5);
        while(!obj.isEmptyQ()){
            System.out.print(obj.dequeue() + " ");
        }
    }
}