import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/maximum-element/problem
public class StackMax{

    public void getMax() throws Exception{
        Stack<Integer> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter operations size : ");
        int opSize = sc.nextInt();
        for(int i=0;i<opSize;i++){
            System.out.println("Please enter operation type : ");
            int ope = sc.nextInt();
            switch(ope){
                case 1:
                    System.out.println("Please enter an element : ");
                    int element = sc.nextInt();
                    st.push(element);
                    break;
                case 2:
                    if(st.isEmpty())
                        throw new Exception("Stacks.Implementation.Stack underflow");
                    st.pop();
                    break;
                case 3:
                    int max = getStackMax(st);
                    System.out.println("Max element is : " + max);
                    break;
            }
        }
    }

    //Why do we even need two stacks ? Refer to the other way with Integer.MIN_VALUE;
    public int getStackMax(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        if(temp.isEmpty()){
            temp.push(st.pop());
        }
        else{
            while(!st.isEmpty()){
                int data = st.pop();
                if(data > temp.peek()){
                    temp.push(data);
                }
            }
        }
        return temp.peek();
    }

    public static void main(String args[]) throws Exception{
        StackMax stackMax = new StackMax();
        stackMax.getMax();
    }
}