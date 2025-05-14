//https://www.geeksforgeeks.org/find-maximum-depth-nested-parenthesis-string/
public class MaximumDepthParenthesis {

    // function takes a string and returns the
    // maximum depth nested parenthesis
    static int maxDepth(String str) {
        int count = 0; // current count
        int maxCount = 0; // overall maximum count
        int n = str.length();

        // Traverse the input string
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            }

            if (str.charAt(i) == ')') {
                if (count > 0) {
                    count--;
                } else {
                    return -1;
                }
            }
        }
        // finally check for unbalanced string
        if (count != 0) {
            return -1;
        }
        return maxCount;
    }

    // Driver program
    public static void main(String[] args) {
        String s1 = "( ((X)) (((Y))) )";
        System.out.println(maxDepth(s1));

        String s2 = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
        System.out.println(maxDepth(s2));

        String s3 = "( p((q)) ((s)t) )";
        System.out.println(maxDepth(s3));

        String s4 = " ";
        System.out.println(maxDepth(s4));

        String s5 = "b) (c) ()";
        System.out.println(maxDepth(s5));

        String s6 = "(b) ((c) ()";
        System.out.println(maxDepth(s6));
    }
}


/*Time Complexity : O(n) ----> n is length of string
Space Complexity : O(1) ----> as no extra datastructure is used

4
4
3
0
-1
-1
*/