import java.util.Stack;

//https://www.youtube.com/watch?v=IY0nZLEg6MA
//https://www.geeksforgeeks.org/expression-evaluation/
public class StringEvaluation{

    public static int evaluateString(String str){
        if(str.length() == 0){
            return -1;
        }
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                operators.push(ch);
            }
            else if(Character.isDigit(ch)){
                operands.push(ch - '0'); //ascii of ch - ascii of 0 (48) will give the actual integer number
            }
            else if(ch == ')'){
                while(operators.peek() != '('){
                    char op = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int result = operation(v1, v2, op);
                    operands.push(result);
                }
                operators.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())){
                    char op = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int result = operation(v1, v2, op);
                    operands.push(result);
                }
                operators.push(ch);
            }
        }

        while(operators.size() != 0){
            char op = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            int result = operation(v1, v2, op);
            operands.push(result);
        }
        return operands.peek();
    }

    public static int precedence(char operator){
        if(operator == '+'){
            return 1;
        }else if(operator == '-'){
            return 1;
        }else if(operator == '*'){
            return 2;
        }else{
            return 2;
        }
    }

    public static int operation(int v1, int v2, char operator){
        if(operator == '+'){
            return v1+v2;
        }else if(operator == '-'){
            return v1-v2;
        }else if(operator == '*'){
            return v1*v2;
        }else{
            return v1/v2;
        }
    }

    public static void main(String args[]){
        System.out.println(evaluateString("2+(5-3*6/2)"));
    }
}


/*
 * Output:
 *
 * -2
 *
 * */