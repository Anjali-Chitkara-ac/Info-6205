package Week2.Day5;

public class LC_456_132Pattern {
    public boolean find132pattern(int[] nums) {
        int min_i = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length - 1; j++) {
            min_i = Math.min(min_i, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && min_i < nums[k]) //min_i & nums[j] will never be equal
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC_456_132Pattern obj = new LC_456_132Pattern();
        int[] nums = new int[]{-1,-2,2,0};
        boolean b = obj.find132pattern(nums);
        System.out.println(b);
    }
}
