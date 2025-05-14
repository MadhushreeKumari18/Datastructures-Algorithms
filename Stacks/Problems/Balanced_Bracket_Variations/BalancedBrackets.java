//Question : https://www.hackerrank.com/challenges/balanced-brackets/problem

import java.util.Stack;

public class BalancedBrackets {

    //https://leetcode.com/problems/valid-parentheses/
    //The below code satisfies all test cases in leetcode
    public static boolean isValid(String s) {
        boolean result = false;
        if(s.length() == 0 || s.length()%2 != 0){
            return result;
        }
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            if(ch1 == '(' || ch1 == '[' || ch1 == '{'){
                st.push(s.charAt(i));
            }
            else if(ch1 == ')' || ch1 == '}' || ch1 == ']'){
                if(st.isEmpty()){
                    result = false;
                    break;
                }
                char ch2 = st.pop();
                switch (ch1) { //dont forget to add breaks after every case otherwise it gives incorrect ans
                    case '}':
                        if (ch2 == '(' || ch2 == '[')
                            return false;
                        break;

                    case ']':
                        if (ch2 == '{' || ch2 == '(')
                            return false;
                        break;

                    case ')':
                        if (ch2 == '[' || ch2 == '{')
                            return false;
                        break;
                }
            }
        }
        return st.isEmpty();
    }
}
