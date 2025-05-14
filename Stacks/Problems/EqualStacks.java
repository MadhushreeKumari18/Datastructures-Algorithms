import java.util.Stack;


//Question: https://www.hackerrank.com/challenges/equal-stacks/problem

public class EqualStacks {

    int arr1[] = {3,2,1,1,1};
    int arr2[] = {4,3,2};
    int arr3[] = {1,1,4,1};
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    Stack<Integer> st3 = new Stack<Integer>();

    public int addElementsToStack(int arr[], Stack<Integer> st){
        int sum=0;
        for(int i=arr.length-1;i>=0;i--){
            st.push(arr[i]);
        }
        for(int j=0;j<arr.length;j++){
            sum = sum+arr[j];
        }
        System.out.println("stack sum : " + sum);
        return sum;
    }

    public int equalCheck(){
        int sum1 = addElementsToStack(arr1, st1);
        int sum2 = addElementsToStack(arr2, st2);
        int sum3 = addElementsToStack(arr3, st3);
        while(sum1!= sum2 || sum1!= sum3 || sum2!= sum3){
            if(sum1> sum2 || sum1> sum3){
                sum1 = sum1-st1.pop();
            }
            else if(sum2> sum1 || sum2> sum3){
                sum2 = sum2-st2.pop();
            }
            else if(sum3> sum1 || sum3> sum2){
                sum3 = sum3-st3.pop();
            }
        }
        return sum1;
    }

    public static void main(String args[]){
        EqualStacks obj = new EqualStacks();
        System.out.println(obj.equalCheck());
    }
}