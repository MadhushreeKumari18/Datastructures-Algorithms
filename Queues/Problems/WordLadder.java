import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
//https://www.youtube.com/watch?v=M9cVl4d0v04 - Nick White
/*
Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
       start = TOON
       target = PLEA
Output: 7
TOON - POON - POIN - POIE - PLIE - PLEE - PLEA
 */
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        int level = 1;

        while(!queue.isEmpty()) {
            //int size = queue.size();
            //for(int i=0;i<size;i++) { //works without this for loop too
            String current_word = queue.poll();
            char word_chars[] = current_word.toCharArray();
            for(int j=0; j<word_chars.length; j++) {
                char original_char = word_chars[j];
                for(char c = 'a'; c<'z'; c++) {
                    if(original_char == c)
                        continue;
                    word_chars[j] = c;
                    String new_word = String.valueOf(word_chars);
                    if(new_word.equals(endWord))
                        return level+1;
                    if(wordList.contains(new_word)) {
                        queue.offer(new_word);
                        wordList.remove(new_word);
                    }
                }
                word_chars[j] = original_char;
            }
            //}
            level++;
        }
        return 0;
    }

    public static void main(String args[]) {
        // make dictionary
        Set<String> dict = new HashSet<String>();
        dict.add("poon");
        dict.add("plee");
        dict.add("same");
        dict.add("poie");
        dict.add("plie");
        dict.add("poin");
        dict.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: " + ladderLength(start, target, dict));
    }

    Set<String> dict2 = new HashSet<String>();
        dict2.add("abcd");
        dict2.add("ebad");
        dict2.add("ebcd");
        dict2.add("xyza");
    String start2 = "abcv";
    String target2 = "ebad";
        System.out.println("Length of shortest chain2 is: " + ladderLength(start2, target2, dict2));
}

/*
 *Length of shortest chain is: 7
 *Length of shortest chain2 is: 4
 *
 * Time complexity: O(n²m), where m is the number of entries originally in the dictionary and n is the size of the string.
 *
 * Auxiliary Space:O(m*n), where m are the strings are stored in queue.
 * So the space Complexity is O(m*n).
 *
 */