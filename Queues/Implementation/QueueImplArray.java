import java.util.Arrays;

//Draw the rear/front diagram
public class Queue {

    int arr[];
    int front;
    int rear;
    int size;

    Queue(int size){
        this.size = size;
        this.arr = new int[size];
        this.front = 0;
        this.rear = -1;
    }

    public void enqueue(int n){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else{
            arr[++rear] = n;
        }
    }

    public boolean isFull(){
        return (rear == size-1);
    }

    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return arr[front++];
    }

    public boolean isEmpty(){
        return (rear == -1 || front>rear);
    }

    public String toString(){
        return Arrays.toString(arr);
    }

    public static void main(String args[]) throws Exception {
        Queue obj = new Queue(4);
        obj.enqueue(100);
        obj.enqueue(200);
        obj.enqueue(300);
        obj.enqueue(400);
        obj.enqueue(500);
        while(!obj.isEmpty()){
            System.out.println(obj.dequeue());
        }
    }
}