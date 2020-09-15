package Sep14;

public class SumOf2Strings {

    public String getSum(String a, String b){
        StringBuilder sb = new StringBuilder();

        //make length equal
        if(a.length()!=b.length()){
            if(a.length()>b.length()){
                b = addZeroPrefixToSmallerNumber(a, b);
            }
            if(b.length()>a.length()){
                a = addZeroPrefixToSmallerNumber(b, a);
            }
        }

        int i=a.length()-1;
        int j=b.length()-1;

        int carry = 0;
        while (i>=0 && j >= 0) {

            int val1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            int val2 = Integer.parseInt(String.valueOf(b.charAt(j)));
            int sum = val1+val2+carry;
            String currSum = String.valueOf(sum);

            if(sum>9){
                carry = 1;
                //convert sum to string
                //append last char to sb
                sb.append(currSum.charAt(currSum.length()-1));
            }
            else {
                carry = 0;
                sb.append(currSum);
            }
            if(i==0 && j==0 && carry > 0){
                sb.append(carry);
            }

            i--;
            j--;
        }
        //reverse sb
        return sb.reverse().toString();
    }

    /*
    @Input a: is the bigger number
    b: is the smaller number.
    We add zeroes to b and return b
     */
    private String addZeroPrefixToSmallerNumber(String a, String b) {
        int diff = a.length() - b.length();
        StringBuilder b_new = new StringBuilder();
        b_new.append(b);
        b_new.reverse();
        int i = 0;
        while (i < diff) {
            b_new.append("0");
            i++;
        }
        b = b_new.reverse().toString();
        return b;
    }

    public static void demo() {
        SumOf2Strings obj = new SumOf2Strings();
        String sum = obj.getSum("345678", "3456789");
        System.out.println(sum);
    }
}
