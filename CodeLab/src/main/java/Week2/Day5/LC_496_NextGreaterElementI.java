package Week2.Day5;

import java.util.*;

public class LC_496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();
        for(int i : nums2) l.add(i);
        int[] nxtGreater = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int idx = l.indexOf(nums1[i]);//index of element in nums2
            if(idx==nums2.length-1){
                nxtGreater[i]=-1;
            }
            for(int j=idx+1;j<nums2.length;j++){
                if(nums2[j]>nums1[i]){
                    nxtGreater[i]=nums2[j];
                    break;
                }else nxtGreater[i] = Integer.MIN_VALUE;
            }
            if(nxtGreater[i]==Integer.MIN_VALUE){
                nxtGreater[i]=-1;
            }
        }
        return nxtGreater;
    }

    public static void main(String[] args) {
        LC_496_NextGreaterElementI obj = new LC_496_NextGreaterElementI();
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        int[] ans = obj.nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }
}
