import java.util.Stack;

//https://www.geeksforgeeks.org/simplify-directory-path-unix-like/
public class GetAbsolutePath {

    public static String getAbsolutePath(String relativePath) {
        Stack<String> st = new Stack<String>();
        String folders[] = relativePath.split("/");
        String result = "";
        for(String folder : folders){
            if(folder.equals("") || folder.equals("."))
                continue;
            if(!folder.equals("..") && !folder.equals(".")){
                st.push(folder);
            }
            else if(folder.equals("..") && !st.isEmpty())
                st.pop();
        }
        int size = st.size();
        String arr[] = new String[size];
        for(int i=size-1;i>=0;i--){
            arr[i] = st.pop();
        }
        for(String s : arr){
            result = result + "/" + s;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(getAbsolutePath("/.././c"));
        System.out.println(getAbsolutePath("/a/bc/def/./.."));
    }
}


/*Output:
 *
 *
 * /c
 * /a/bc
 *
 */