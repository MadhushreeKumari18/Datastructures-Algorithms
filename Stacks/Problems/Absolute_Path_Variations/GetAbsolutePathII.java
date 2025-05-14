import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//Present working directory and command would be given return the result
public class DirectoryChange{

    public static String changeDirectoryString(String currentDirectory, String command) throws Exception{
        Stack<String> st = new Stack<>();
        String result = "";
        try{
            String folders[] = currentDirectory.split("/");
            for(String folder : folders){
                if(folder.equals(""))
                    continue;
                st.push(folder);
            }
            String commands1[] = command.split("\\s");
            String commands2[] = new String[100];
            if(commands1.length > 1){
                commands2 = commands1[1].split("/");
            }
            Queue<String> q = new LinkedList<>();
            q.add(commands1[0]);
            for(String s2 : commands2){
                q.add(s2);
            }
            while(!q.isEmpty()){
                String temp = q.poll();
                if(q.size() == 0 && temp.equals("/")) {
                    result = "/";
                    return result;
                }
                if(temp.equals("cd") || temp.equals(" ") || temp.equals(""))
                    continue;
                else if(temp.equals(".."))
                    st.pop();
                else
                    st.push(temp);
            }
            int size = st.size();
            String arr[] = new String[size];
            for(int i=size-1;i>=0;i--){
                arr[i] = st.pop();
            }
            for(String s : arr){
                result = result + "/" + s;
            }
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
        return result;
    }


    public static void main(String args[]) throws Exception {
        System.out.println(changeDirectoryString("/dev/task", "cd java"));
        System.out.println(changeDirectoryString("/dev/task", "cd /"));
        System.out.println(changeDirectoryString("/dev/task", "cd .."));
        System.out.println(changeDirectoryString("/dev/task", "cd ../solution"));
    }
}


/*
Output:

/dev/task/java
/dev/task
/dev
/dev/solution
* */