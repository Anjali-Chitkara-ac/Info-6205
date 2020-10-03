package Week2.Day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_503_NextGreaterII {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        List<Integer> list = new ArrayList<>();
        for(int i : nums) list.add(i);
        for(int i : nums) list.add(i);
        for(int i=0;i<len;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(j)>list.get(i)){
                    result[i]=list.get(j);
                    break;
                }else result[i]=Integer.MIN_VALUE;
            }
            if(result[i]==Integer.MIN_VALUE){
                result[i]=-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC_503_NextGreaterII obj = new LC_503_NextGreaterII();
        int[] nums = new int[]{5,4,3,2,1};
        int[] result = obj.nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }
}
