import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/game-of-two-stacks/problem
public class GameOfTwoStacks {

    int arr1[] = {7,15,12,0,5,18,17,2,10,15,4,2,9,15,13,12,16};
    int arr2[] = {12,16,6,8,16,15,18,3,11,0,17,7,6,11,14,13,15,6,18,6,16,12,16,11,16,11};
    int limit = 62;
    int count = 0;
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void addElementsToStack(int arr[], Stack<Integer> st){
        for(int i=arr.length-1;i>=0;i--){
            st.push(arr[i]);
        }
    }

    public int game(){
        int sum = 0;
        addElementsToStack(arr1, stack1);
        addElementsToStack(arr2, stack2);
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int n1 = stack1.pop();
            int n2 = stack2.pop();
            count = count + 2;
            sum = n1+n2;
            if(sum > limit){
                return count - 2;
            }
        }
        return count;
    }


    public int game2(){
        int sum = 0;
        addElementsToStack(arr1, stack1);
        addElementsToStack(arr2, stack2);
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int n1 = stack1.pop();
            int n2 = stack2.pop();
            count = count + 2;
            sum += n1+n2;
            while(sum > limit){
                sum = sum - n1;
                return count - 2;
            }
        }
        return count;
    }

    public static void main(String args[]){
        GameOfTwoStacks obj = new GameOfTwoStacks();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter limit : ");
//		int limit = sc.nextInt();
//		System.out.println("Enter first array");
//		int arr1[] = new int[3];
//		for(int i=0;i<arr1.length;i++){
//			arr1[i] = sc.nextInt();
//		}
//		System.out.println("Enter second array");
//		int arr2[] = new int[17];
//		for(int j=0;j<arr2.length;j++){
//			arr2[j] = sc.nextInt();
//		}

        int x = obj.game();
        System.out.println(x);
    }
}