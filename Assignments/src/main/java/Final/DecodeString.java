package Final;

import java.util.Stack;

public class DecodeString {
    /*Q7
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,k.
For example, there won't be input like 3a or 2[4].

Example:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
    public String decodeString(String s) {
        if(s.length()==0) return "";
        Stack<Character> stack = new Stack();
        int num=0;
        for (int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){
                int intVal = Character.getNumericValue(curr);
                num = num*10 + intVal;
            }else if(curr=='['){
                stack.push((char) num);
                stack.push(curr);
                num =0;
            }else if(curr==']'){
                num = 0;
                StringBuilder curr_sb = new StringBuilder();
                StringBuilder result = new StringBuilder();
                while (stack.peek()!='['){
                    curr_sb.append(stack.pop());
                }
                stack.pop();
                int temp = stack.pop();
                curr_sb.reverse();
                for (int j=0;j<temp;j++){
                    result.append(curr_sb);
                }
                for(char c : result.toString().toCharArray()){
                    stack.push(c);
                }
            }
            else{
                num=0;
                stack.push(curr);
            }
        }
        StringBuilder decoded = new StringBuilder();
        for(char c : stack){
            decoded.append(c);
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        String str = obj.decodeString("3[a2[c]]");
        System.out.println(str);
    }
}
