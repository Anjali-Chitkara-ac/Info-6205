package Final;

public class SumOfTwoStrings {
    /*Q1
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

    public static String addStrings(String num1, String num2){
        //make length equal
        if(num1.length()!=num2.length()){
            int l1 = num1.length();
            int l2 = num2.length();
            int diff = Math.abs(l1-l2);
            if(l1>l2){
                StringBuilder sb = new StringBuilder(num2).reverse();
                while (diff!=0){
                    sb.append("0");
                    diff--;
                }
                num2 = sb.reverse().toString();
            } else {
                StringBuilder sb = new StringBuilder(num1).reverse();
                while (diff!=0){
                    sb.append("0");
                    diff--;
                }
                num1 = sb.reverse().toString();
            }
        }

        StringBuilder total = new StringBuilder();
        int carry = 0;
        int j = num2.length();
        for(int i=num1.length();i>0;i--){
            int a = Integer.parseInt(num1.substring(i-1,i));
            int b = Integer.parseInt(num2.substring(j-1,j));
            int sum = a + b + carry;
            if(sum>9){
                total.append((sum % 10));
                carry = 1;
            }
            else {
                total.append(sum);
                carry = 0;//reset carry after using
            }
            j--;
        }
        total.append(carry);
        //remove zeroes from the front
        String result = total.reverse().toString();
        while (result.charAt(0)=='0'){
            result = result.substring(1);
            if(result.equals("")){
                return "0";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = addStrings("99", "22");
        System.out.println(result);
    }
}
