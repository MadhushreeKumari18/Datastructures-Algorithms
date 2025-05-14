public class StackReverse{

    //This is the ideal way to do it, while pushing itself u have to push to a queue instead of a stack
    public void push(int data){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(data);
    }

    //This will give u the reverse
    public int pop(){
        if(queue.isEmpty()){
            throw new Exception("Stacks.Implementation.Stack is empty");
        }
        return queue.poll();
    }
}