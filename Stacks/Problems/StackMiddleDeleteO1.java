import java.util.Stack;

//https://www.youtube.com/watch?v=ua1bPxSV_H0
//https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/




//   1 ---> 2 ---> 3 ---> 4 ---> 5
// head    head   head   head   head
// mid     mid    mid
// s=1     s=2    s=3    s=4    s=5
public class StackMiddleDeleteO1 {

    static class Node{
        Node next;
        Node prev;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    Node head;
    Node mid;
    int size;

    void push(int data){
        Node newNode = new Node(data);
        if(size == 0){
            head = newNode;
            mid = newNode;
            size++;
            return;
        }
        head.next = newNode;
        newNode.prev = head;
        head = head.next;
        if(size%2 == 0){
            mid = mid.next;
        }
        size++;
    }

    int pop(){
        int result = -1;
        if(size != 0){
            if(size == 1){
                result = head.data;
                head = null;
                mid = null;
            }
            else{
                result = head.data;
                head = head.prev;
                head.next = null;
                if(size%2 == 0){
                    mid = mid.prev;
                }
            }
            size--;
        }
        return result;
    }

    int findMiddle(){
        int result = -1;
        if(size != 0){
            result = mid.data;
        }
        return result;
    }

    void deleteMiddleElement(){
        if(size != 0){
            if (size == 1) {
                head = null;
                mid = null;
            }
            else if (size == 2) {
                head = head.prev;
                mid = mid.prev;
                head.next = null;
            }
            else {
                mid.next.prev = mid.prev;
                mid.prev.next = mid.next;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
                else {
                    mid = mid.next;
                }
            }
            size--;
        }
    }

    public static void main(String args[]){
        StackMiddleDeleteO1 obj = new StackMiddleDeleteO1();
        for(int i=1;i<=5;i++){
            obj.push(i);
        }
        //System.out.println("Middle element:: " + obj.findMiddle());
        obj.deleteMiddleElement();
        while(obj.head != null){
            System.out.println(obj.pop());
        }
    }
}

/*
*

5
4
2
1

*
*
* */