import java.util.LinkedList;

//Please check the need of rear, it can work without that as well with the help of list size
public class QueueUsingList {

    LinkedList<Integer> list;
    int top;

    QueueUsingList(){
        this.list = new LinkedList<Integer>();
        this.top = -1;
    }

    public void enqueue(int data) {
        list.add(data);
        top++;
    }

    public int dequeue() throws Exception{
        if(isEmpty())
            throw new Exception("Underflow");
        int result = list.remove();
        top--;
        return result;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String args[]) throws Exception {
        QueueUsingList queue = new QueueUsingList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        //System.out.println(queue.dequeue());
    }
}