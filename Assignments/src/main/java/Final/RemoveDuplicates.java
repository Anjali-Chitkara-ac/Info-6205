package Final;

import java.util.Stack;

public class RemoveDuplicates {
    /*Q3
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and
removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

Example:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
*/
    public static String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(curr);
                countStack.push(1);
            }
            else {
                char top = stack.peek();
                stack.push(curr);
                if(top==curr){
                    countStack.push(countStack.pop()+1);
                    if(countStack.peek()==k){
                        for (int j=0;j<k;j++){
                            stack.pop();
                        }
                        countStack.pop();
                    }
                } else {
                    countStack.push(1);
                }
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
         String result = removeDuplicates("deeedbbcccbdaa",3);
//         String result = removeDuplicates("abcd",2);
//         String result = removeDuplicates("",3);
         System.out.println(result);
    }
}
