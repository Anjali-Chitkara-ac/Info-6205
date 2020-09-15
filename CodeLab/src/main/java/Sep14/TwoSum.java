package Sep14;

import java.util.*;

public class TwoSum {

    /*
    Time Complexity : O(2n)
     */
    public int[] getIdx(int[]nums, int target){
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0]=i;
                ans[1]= map.get(target-nums[i]);
                if(ans[0]!=ans[1]) {
                    return ans;
                }
            }
        }
        return ans;
    }

    /*
    Time complexity : O(n^2)
     */
    public int[] getIdx2(int[]nums, int target){
        int[] ans = new int[2];
        for (int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(nums[i]+nums[j]==target && i!=j){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void demo(){
        TwoSum obj = new TwoSum();

        int[] nums = new int[]{3,2,4};
        int [] ans = obj.getIdx(nums,6);
        System.out.println(Arrays.toString(ans));
    }
}
