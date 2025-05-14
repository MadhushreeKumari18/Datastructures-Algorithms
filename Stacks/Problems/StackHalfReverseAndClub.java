import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*Given a stack of N elements, interleave the first half of the stack with the second half reversed using only one other queue.
This should be done in-place.

Recall that you can only push or pop from a stack, and enqueue or dequeue from a queue.

For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4, 3].
If the stack is [1, 2, 3, 4], it should become [1, 4, 2, 3].
*/

//Only one queue and one stack needs to be used
public class StackHalfReverseAndClub {

    public static void stackHalfReverseAndClub(Stack<Integer> st) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int halfSize = st.size()/2;
        //push half of stack into queue
        for(int i=0;i<halfSize;i++) {
            queue.add(st.pop());
        }
        //reverse the queue
        int qSize = queue.size();
        for(int i=0;i<qSize;i++) {
            st.push(queue.poll());
        }

        for(int j=0;j<qSize;j++) {
            queue.offer(st.pop());
        }

        //pop from stack and poll from queue
        int size = queue.size();
        while(!st.isEmpty()) {
            queue.offer(st.pop());
            if(size > 0) {
                queue.offer(queue.poll());
                size--;
            }
        }

        //reverse the queue
        int newQSize = queue.size();
        for(int i=0;i<newQSize;i++) {
            st.push(queue.poll());
        }

        for(int i=0;i<newQSize;i++) {
            queue.offer(st.pop());
        }

        //print queue
        while(!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static void main(String args[]) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        stackHalfReverseAndClub(st);
    }
}