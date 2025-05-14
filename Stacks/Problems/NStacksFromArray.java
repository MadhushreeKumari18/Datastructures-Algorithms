import java.util.Arrays;

/**
 * Describe how you could use a single array to implement three or N stacks.
 *
 * arr indexes:::::: [[0 ---- 49], [50------99], [100------149]
 */
public class NStacksFromArray {

    private static final int STACK_SIZE = 50;
    private static final int STACK_NUM = 3;
    private int[] arr = new int[STACK_SIZE * STACK_NUM]; //buffer is nothing but the array
    private static int[] stackPointers = new int[STACK_NUM];
    static {
        Arrays.fill(stackPointers, -1);
    }

    public void push(int stackNum, int item) {
        if (isFull(stackNum))
            throw new IllegalArgumentException("Stacks.Implementation.Stack " + stackNum + " is full!");
        ++stackPointers[stackNum];
        arr[getArrayIndex(stackNum)] = item;
    }

    public boolean isFull(int stackNum) {
        if (stackNum < 0 || stackNum >= STACK_NUM)
            throw new IllegalArgumentException("Stacks.Implementation.Stack " + stackNum + " doen't exist!");
        return stackPointers[stackNum] >= STACK_SIZE - 1;
    }

    private int getArrayIndex(int stackNum) {
        return stackPointers[stackNum] + stackNum * STACK_SIZE;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum))
            throw new IllegalArgumentException("Stacks.Implementation.Stack " + stackNum + " is empty!");
        int val = arr[getArrayIndex(stackNum)];
        --stackPointers[stackNum];
        return val;
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum < 0 || stackNum >= STACK_NUM)
            throw new IllegalArgumentException("Stacks.Implementation.Stack " + stackNum + " doen't exist!");
        return stackPointers[stackNum] <= -1;
    }

    public void printStack(int stackNum) {
        if (stackNum < 0 || stackNum >= STACK_NUM)
            throw new IllegalArgumentException("Stacks.Implementation.Stack " + stackNum + " doen't exist!");
        int top = getArrayIndex(stackNum);
        int btm = stackNum * STACK_SIZE;
        System.out.print("Stacks.Implementation.Stack " + stackNum + ": ");
        for (int i = btm; i <= top; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("[TOP]");
    }

    public void printStacks() {
        for (int i = 0; i < STACK_NUM; ++i) {
            printStack(i);
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        NStacksFromArray stack = new NStacksFromArray();
        stack.printStacks();
        System.out.println();
        stack.push(0, -1); stack.push(0, -2); stack.push(0, -3);
        stack.push(1, 1); stack.push(1, 2); stack.push(1, 3);
        stack.push(2, 10); stack.push(2, 20); stack.push(2, 30); stack.push(2, 40);
        stack.printStacks();
        System.out.println();
        System.out.println("Pop Stacks.Implementation.Stack 0: " + stack.pop(0));
        System.out.println("Pop Stacks.Implementation.Stack 1: " + stack.pop(1));
        System.out.println("Pop Stacks.Implementation.Stack 1: " + stack.pop(1));
        System.out.println("Pop Stacks.Implementation.Stack 2: " + stack.pop(2));
        System.out.println();
        stack.printStacks();
    }
}