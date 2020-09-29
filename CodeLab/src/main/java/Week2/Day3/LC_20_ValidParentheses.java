package Week2.Day3;

import java.util.*;

public class LC_20_ValidParentheses {
    public boolean isValid(String s){
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else {//if closing brackets
                if(!stack.isEmpty()) {
                    Character c = stack.peek();
                    if (map.get(s.charAt(i)) == c) {
                        stack.pop();
                    } else {
                        count++;
                    }
                } else return false;
            }
        }
        if(stack.isEmpty() && count==0){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        LC_20_ValidParentheses obj = new LC_20_ValidParentheses();
        boolean b = obj.isValid("(])");
        System.out.println(b);
    }

}
