import java.util.Stack;


/**
 * How would you design a stack which, in addition to push
 * and pop, also has a function min which returns the minimum
 * element? Push, pop and min should all operate in O(1) time.
 */

//Without 2 stacks
public class StackMinTest {

    public static int getMin(Stack st) throws Exception {
        int min = Integer.MAX_VALUE, temp = 0;
        while(!st.isEmpty()){
            temp = st.pop();
            if(temp < min)
                min = temp;
        }
        return min;
    }

    public static int getMax(Stack st) throws Exception {
        int max = Integer.MIN_VALUE, temp =0;
        while(!st.isEmpty()){
            temp = st.pop();
            if(temp > max){
                max = temp;
            }
        }
        return max;
    }

    public static void main(String args[]) throws Exception {
        Stack st1 = new Stack(5);
        for(int i=1;i<st1.size+1;i++){
            st1.push(i*10);
        }
        System.out.println("Minimum : " + getMin(st1));

        Stack st2 = new Stack(5);
        for(int i=1;i<st2.size+1;i++){
            st2.push(i*10);
        }
        System.out.println("Maximum : " + getMax(st2));
    }
}

/*
Output:

Minimum : 10
Maximum : 50

*/

----------------------------------------------------------------------------------------

//When array is an input, do we really need two stacks when input is array ??
//just traverse the array and keep a interger max.. wil be enough
public class StackGetMin {

    static int getMin(int arr[]){
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();

        for(int i=0;i<arr.length;i++){
            if(st1.isEmpty() && st2.isEmpty()){
                st1.push(arr[i]);
                st2.push(arr[i]);
            }
            else{
                st1.push(arr[i]);
                if(st1.peek() < st2.peek()){
                    st2.push(arr[i]);
                }
            }
        }
        return st2.peek();
    }

    public static void main(String args[]){
        int arr[] = {7,10,5,6,2};
        System.out.println(getMin(arr));
    }
}

// When stack is an input
public class StackMinimum {

    public static int getMinimum(Stack<Integer> st){
        Stack<Integer> temp = new Stack<Integer>();
        while(!st.isEmpty()){
            if(temp.isEmpty()){
                temp.push(st.pop());
            }
            else{
                int element = st.pop();
                while(!temp.isEmpty() && temp.peek() < element){
                    st.push(temp.pop());
                }
                temp.push(element);
            }
        }
        return temp.pop();
    }

    public static void main(String args[]){
        Stack<Integer> st = new Stack<Integer>();
        st.add(100);
        st.add(300);
        st.add(1);
        st.add(9);
        st.add(500);
        System.out.println(getMinimum(st));
    }
}

--------------------------------------------------------------------------------------------
