import java.util.*;

//https://www.youtube.com/watch?v=-7yxUliSJBo
public class Validation {

    private static Map<Character, Character> bracketMap = new HashMap<>();
    private static Set<Character> closedBrackets = new HashSet<>();
    static{
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');
        closedBrackets = new HashSet<>(bracketMap.values());
    }

    public static boolean isValid(String bracketInput){
        Stack<Character> bracketStack = new Stack<>();
        for(char currentBracket : bracketInput.toCharArray()){
            if(bracketMap.containsKey(currentBracket)){
                bracketStack.push(currentBracket);
            }
            else if(closedBrackets.contains(currentBracket)){
                if(!isValidClosedBracket(bracketStack, currentBracket)){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return bracketStack.isEmpty();
    }

    private static boolean isValidClosedBracket(Stack<Character> bracketStack, Character currentBracket){
        if(bracketStack.isEmpty()){
            return false;
        }
        char openBracket = bracketStack.pop();
        char validClosedBracket = bracketMap.get(openBracket);
        if(currentBracket != validClosedBracket){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(isValid("()"));
        System.out.println(isValid("(}"));
    }
}