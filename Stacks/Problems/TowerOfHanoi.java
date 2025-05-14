import java.util.Stack;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with disks sorted
 * in ascending order of size from top to bottom (i.e., each disk sits on top
 * of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
public class TowerOfHanoi {

    public static void solution(Stack<Integer> src, Stack<Integer> dest, Stack<Integer> helper, int n){
        if(n == 1){
            moveDisk(src, dest);
            return;
        }
        solution(src, helper, dest, n-1);
        moveDisk(src, dest);
        solution(helper, dest, src, n-1);
    }

    public static void moveDisk(Stack<Integer> src, Stack<Integer> dest){
        dest.push(src.pop());
    }

    public static void main(String args[]){
        Stack<Integer> src = new Stack<>();
        for(int i=5;i>0;i--){
            src.push(i);
        }
        Stack<Integer> dest = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        solution(src, dest, helper, 5);
        while(!dest.isEmpty()){
            System.out.println(dest.pop());
        }
    }
}



/*
*

1
2
3
4
5

*
* */