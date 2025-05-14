import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueNElements {

    static Queue<Integer> reverseQueueN(Queue<Integer> input, int k){
        Stack<Integer> st = new Stack<Integer>();
        Queue<Integer> tempQueue = new LinkedList<Integer>();

        for(int i=0;i<k;i++){
            st.push(input.poll());
        }
        while(!st.isEmpty()){
            tempQueue.add(st.pop());
        }
        while(!input.isEmpty()){
            tempQueue.add(input.poll());
        }
        return tempQueue;
    }

    public static void main(String args[]){
        Queue<Integer> input = new LinkedList<Integer>();
        int k = 5;
        input.add(10);
        input.add(20);
        input.add(30);
        input.add(40);
        input.add(50);
        input.add(60);
        input.add(70);
        input.add(80);
        input.add(90);
        input.add(100);

        Queue<Integer> result = reverseQueueN(input,k);
        while(!result.isEmpty()){
            System.out.print(result.poll() + " ");
        }
    }
}