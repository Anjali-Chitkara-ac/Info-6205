package Sep14;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k){
        if(k>nums.length){
            k=k-nums.length;
        }
        int[] copy = new int[nums.length];
        int a = nums.length;
        for(int i=0;i<nums.length;i++){
            copy[i] = nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(i+k<nums.length) {
                nums[i+k] = copy[i];
            }
            else{
                nums[nums.length - a] = copy[i];
                a = a - 1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void demo(){
        RotateArray obj = new RotateArray();

        int[] nums = new int[]{6,2,3,4,8};
        obj.rotate(nums,2);
    }
}
