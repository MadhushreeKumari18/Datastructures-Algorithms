import java.util.Stack;

//You have given a string that contains the braces (brackets),
// both opening and closing braces.
// You have to find the length of the longest balanced subarray.
//
//
//
//Input : {}{}{()[]()

//{{
//Output: 6
public class LongestBalancedSubarrayBracket {

    public static int solution(String str){
        if(str.length() == 0){
            return -1;
        }
        Stack<Character> st = new Stack<>();
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++){//{}{}{()[]()
            char ch = str.charAt(i);//)
            if(ch == '{' || ch == '[' || ch == '('){
                st.push(ch); //{(
            }
            else{
                if(st.isEmpty()){
                    return maxSum;
                }
                char ch2 = st.pop();//(
                if(st.size() == 1){
                    st.pop();
                    currentSum = 0;
                }
                switch(ch2){//(
                    case '{':
                        if(ch == '}'){
                            currentSum += 2;//0
                            maxSum = currentSum > maxSum ? currentSum : maxSum;//4
                            break;
                        }
                        else{
                            currentSum = 0;
                            break;
                        }
                    case '[':
                        if(ch == ']'){
                            currentSum += 2;//4
                            maxSum = currentSum > maxSum ? currentSum : maxSum;//4
                            break;
                        }
                        else{
                            currentSum = 0;
                            break;
                        }
                    case '(':
                        if(ch == ')'){
                            currentSum += 2;//2
                            maxSum = currentSum > maxSum ? currentSum : maxSum;//4
                            break;
                        }
                        else{
                            currentSum = 0;
                            break;
                        }
                }
            }
        }
        return maxSum;
    }

    public static void main(String args[]){
        System.out.println(solution("{}{}{()[]()"));
        System.out.println(solution("[][][]()}(){}"));
    }
}