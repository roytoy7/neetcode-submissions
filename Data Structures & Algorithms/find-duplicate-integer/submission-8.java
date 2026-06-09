class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i])-1;
            if (nums[num] < 0) return Math.abs(nums[i]);
            else {
                nums[num] *= -1;
            }
        }
        return nums[nums.length-1];
    }
}
