import java.util.Stack;

/*
*
Bracket Match
A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa.
For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t.
For instance, “((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.

Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input
and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.

Explain the correctness of your code, and analyze its time and space complexities.

Examples:
--------
input:  text = “(()”
output: 1

input:  text = “(())”
output: 0

input:  text = “())(”
output: 2
*
* */

public class BracketMatch {

    static int bracketMatch(String text) {
        //Stack<Character> st = new Stack<>();
        int openCount = 0;
        int closedCount = 0;
        int result = 0;
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch == '('){
                openCount++;
            }
            else{
                if(openCount != 0){
                    openCount--;
                }
                else{
                    closedCount++;
                }
            }
        }
        result = openCount + closedCount;
        return result;
    }

    public static void main(String args[]){
        System.out.println(bracketMatch("(()"));
        System.out.println(bracketMatch("(())"));
        System.out.println(bracketMatch("())("));
        System.out.println(bracketMatch("(()(()"));
        System.out.println(bracketMatch("()))"));
    }
}


/*
*

1
0
2
2
2

*
*
* */