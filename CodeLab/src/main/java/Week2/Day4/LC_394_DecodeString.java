package Week2.Day4;

import java.util.Stack;

public class LC_394_DecodeString {
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
        LC_394_DecodeString obj = new LC_394_DecodeString();
        String ans = obj.decodeString("3[a2[c]]");
        System.out.println(ans);

    }
}
