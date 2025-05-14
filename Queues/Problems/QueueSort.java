import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSort {

    static Queue<Integer> sortQueue(Queue<Integer> input){
        Stack<Integer> st = new Stack<Integer>();
        while(!input.isEmpty()){
            if(st.isEmpty()){
                st.push(input.poll());
            }
            else{
                int temp1 = input.poll();
                int temp2 = st.peek();
                if(temp1<temp2){
                    st.push(temp1);
                }
                else{
                    while(!st.isEmpty() && temp1>st.peek()){ //be careful here, ensuring that the greatest number is at the bottom of the stack
                        input.add(st.pop());
                    }
                    st.push(temp1);
                }
            }
        }
        while(!st.isEmpty()){
            input.add(st.pop());
        }
        return input;
    }

    public static void main(String args[]){
        Queue<Integer> input = new LinkedList<Integer>();
        input.add(11);
        input.add(5);
        input.add(4);
        input.add(21);

        Queue<Integer> result = sortQueue(input);
        while(!result.isEmpty()){
            System.out.print(result.poll()  + " ");
        }
    }
}

//4 5 11 21