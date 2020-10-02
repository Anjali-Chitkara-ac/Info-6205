package Week2.Day4;

import java.util.Stack;

public class LC_402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int expLen = num.length()-k;
        if(expLen==0) return String.valueOf(0); //10,2

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            int currInt = Character.getNumericValue(num.charAt(i));
            if(stack.isEmpty()) stack.push(currInt);
            else{
                    while (!stack.isEmpty() && currInt < stack.peek() && k > 0) {
                        stack.pop();
                        k--;
                    }
                stack.push(currInt);
            }
        }
        //convert stack to sb
        StringBuilder sb = new StringBuilder();
        for(int i : stack){
            sb.append(String.valueOf(i));
        }
        String ans = sb.toString();
        if(ans.length()>expLen){
            //trim last elements of stack
            ans = sb.substring(0,expLen);
        }
        //if there are extra zeroes in the beginning
        while (ans.charAt(0)=='0' && ans.length()>1){
            ans = ans.substring(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC_402_RemoveKDigits obj = new LC_402_RemoveKDigits();
        String s = obj.removeKdigits("10",1);
        System.out.println(s);
    }
}
