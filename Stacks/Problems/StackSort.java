import java.util.Stack;

public class StackSort {

    private static Stack<Integer> sortstack(Stack<Integer> input) {
        // TODO Auto-generated method stub
        Stack<Integer> tmpStack = new Stack<>();
        while(!input.isEmpty()){
            int temp = input.pop();
            if(tmpStack.isEmpty()){
                tmpStack.push(temp);
            }else{
                int temp2 = tmpStack.peek();
                if(temp2>temp){
                    tmpStack.push(temp);
                }else{
                    while(!tmpStack.isEmpty()  && temp<tmpStack.peek() ){
                        //pushing all greater value elements to the input stack so that elements are not lost
                        input.push(tmpStack.pop());
                    }
                    tmpStack.push(temp);
                }
            }
        }
        return tmpStack;
    }

    public static void main(String[] args) {

        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack
        Stack<Integer> tmpStack = sortstack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty()) {
            System.out.print(tmpStack.pop() + " ");
        }
    }
}