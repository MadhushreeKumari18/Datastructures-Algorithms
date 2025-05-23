import java.util.Stack;


//https://www.geeksforgeeks.org/prefix-postfix-conversion/
public class PrefixToPostfix {

    // Convert prefix to Postfix expression
    static String preToPost(String pre_exp)
    {
        Stack<String> s= new Stack<String>();

        // length of expression
        int length = pre_exp.length();

        // reading from right to left
        for (int i = length - 1; i >= 0; i--)
        {
            // check if symbol is operator
            if (!isOperator(pre_exp.charAt(i)))
            {
                // push the operand to the stack
                // "" is mainly to convert the character to string
                s.push( pre_exp.charAt(i)+"");
            }
            // if symbol is an operand
            else
            {
                // pop two operands from stack
                String op1 = s.peek(); s.pop();
                String op2 = s.peek(); s.pop();

                // concat the operands and operator
                String temp = op1 + op2 + pre_exp.charAt(i);

                // Push String temp back to stack
                s.push(temp);
            }
        }
        // stack contains only the Postfix expression
        return s.peek();
    }

    // funtion to check if character
    // is operator or not
    static boolean isOperator(char x)
    {
        switch (x)
        {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    // Driver Code
    public static void main(String args[])
    {
        String pre_exp = "*-A/BC-/AKL";
        System.out.println("Postfix : " + preToPost(pre_exp));
    }
}