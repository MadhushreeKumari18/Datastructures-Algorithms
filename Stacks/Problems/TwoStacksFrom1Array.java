import java.util.Arrays;

public class TwoStacksFrom1Array {

    static final int MAX_STACK = 10;
    int topA = 0, topB = MAX_STACK;
    static final int arr[] = new int[MAX_STACK];

    public void pushA(int item){
        if(topA-1 == topB || topA == MAX_STACK-1 || topB == 0) {
            System.out.println("Stacks.Implementation.Stack overflow");
            return;
        }
        arr[topA] = item;
        topA++;
    }

    public void pushB(int item){
        if(topA-1 == topB || topA == MAX_STACK-1 || topB == 0) {
            System.out.println("Stacks.Implementation.Stack overflow");
            return;
        }
        if(topB == MAX_STACK) {
            topB = MAX_STACK-1;
        }
        else {
            topB--;
        }
        arr[topB] = item;
    }

    public void popA() {
        if(topA == 0) {
            System.out.println("Stacks.Implementation.Stack underflow");
            return;
        }
        int result = arr[topA];
        topA--;
        System.out.println("PopA : " + result);
    }

    public void popB() {
        if(topB == 0) {
            System.out.println("Stacks.Implementation.Stack underflow");
            return;
        }
        int result = arr[topB];
        if(topB == MAX_STACK) {
            topB = 0;
        }
        else {
            topB++;
        }
        System.out.println("PopB : " + result);
    }

    public static void main(String args[]) {
        TwoStacksFrom1Array obj = new TwoStacksFrom1Array();
        obj.pushA(10);
        obj.pushA(20);
        obj.pushB(30);
        obj.pushA(40);
        obj.pushA(50);
        obj.pushA(60);
        System.out.println(Arrays.toString(arr));
        obj.pushB(1);
//		obj.pushB(2);
        obj.pushB(3);
//		obj.pushA(4);
        System.out.println(Arrays.toString(arr));
    }
}