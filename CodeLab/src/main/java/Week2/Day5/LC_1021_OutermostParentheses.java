package Week2.Day5;

import java.util.Stack;

public class LC_1021_OutermostParentheses {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int j=0;
        int b = 2;//for outermost brackets
        for(int i=0;i<S.length();i++){
            char curr = S.charAt(i);
            if(curr=='('){
                stack.push(curr);
            }else stack.pop();

            if(stack.isEmpty()){
                sb.append(S.substring(j+1,i));
                j=sb.length()+b;
                b+=2;//for extra brackets in every iteration
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_1021_OutermostParentheses obj = new LC_1021_OutermostParentheses();
        String ans = obj.removeOuterParentheses("(()())(())(()(()))");
        System.out.println(ans);
    }
}
