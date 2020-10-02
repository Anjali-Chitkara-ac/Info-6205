package Week2.Day4;

import jdk.jshell.Snippet;

import java.util.Stack;

public class LC_224_BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int number = 0;

        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                number = 10 * number + Character.getNumericValue(c);
            } else if(c == '+') {
                result = result + number * sign;

                number = 0;
                sign = 1;

            } else if(c == '-') {
                result = result + number * sign;

                number = 0;
                sign = -1;
            } else if (c == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (c == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * number;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                number = 0;
            }
        }

        return result + (number * sign);
    }

    public static void main(String[] args) {
        LC_224_BasicCalculator obj = new LC_224_BasicCalculator();
        int total = obj.calculate("(2-(3+1-1))");
        System.out.println(total);
    }

}
